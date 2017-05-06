package com.cmsc508.repository;

import com.cmsc508.model.Project;
import com.cmsc508.model.Star;
import com.cmsc508.rowmapper.ProjectRowMapper;
import com.cmsc508.rowmapper.StarRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created by Pulkit on 5/5/2017.
 */
public class StarRepository extends BaseRepository {

    public StarRepository(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    public void insertStarred(Long studentId, Integer projectId) {
        jdbcTemplate.update("insert into stars (studentId, projectId) VALUES (?,?)", new Object[]{studentId, projectId});

    }

    public List<Star> getStarred(Integer studentId) {
        List<Star> stars = jdbcTemplate.query("select * from stars where studentId = ?", new StarRowMapper(), studentId);
        return stars;
    }

}
