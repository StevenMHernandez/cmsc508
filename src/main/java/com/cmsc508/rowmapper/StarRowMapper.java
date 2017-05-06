package com.cmsc508.rowmapper;

import com.cmsc508.model.Star;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Pulkit on 5/5/2017.
 */
public class StarRowMapper implements RowMapper<Star> {

        @Override
        public Star mapRow(ResultSet rs, int rowNum) throws SQLException {
            Star star = new Star();
            star.setProjectId(rs.getLong("studentId"));
            star.setStudentId(rs.getInt("projectId"));
            return star;
        }
}
