package com.cardpay.incubator.camel.dao;

import com.cardpay.incubator.camel.dao.beans.GeoIpDataBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

import static java.lang.String.format;
import static java.util.Arrays.asList;
import static java.util.Collections.EMPTY_MAP;

@Component
public class GeoIpDao {
    private final static List<String> ALLOWED_SORT_COLUMNS = asList("ADDED", "IP", "COUNTRY", "CITY", "SERVICE");

    @Autowired
    NamedParameterJdbcTemplate template;

    @SuppressWarnings("unchecked")
    public Long count() {
        return template.queryForObject("SELECT count(1) FROM geoip", EMPTY_MAP, Long.class);
    }

    @SuppressWarnings("serial")
    public List<GeoIpDataBean> query(Integer page, Integer pageSize, String sortColumn, String sortOrder) {
        return template.query(
                format("SELECT * FROM geoip ORDER BY %s %s OFFSET :offset LIMIT :limit", checkedColumn(sortColumn), checkedOrder(sortOrder)),
                new HashMap<String, Object>() {{
                    put("offset", (page - 1) * pageSize);
                    put("limit", pageSize);
                }},
                (rs, rowNum) -> new GeoIpDataBean(rs.getTimestamp("added"), rs.getString("ip"), rs.getString("country"), rs.getString("city"), rs.getString("service"))
        );
    }

    private String checkedColumn(String sortColumn) {
        return ALLOWED_SORT_COLUMNS.contains(sortColumn.toUpperCase()) ? sortColumn : ALLOWED_SORT_COLUMNS.get(0);
    }

    private String checkedOrder(String sortOrder) {
        return ("ASC".equals(sortOrder.toUpperCase()) ? "ASC" : "DESC");
    }
}
