package com.cmsc508.repository;

import com.cmsc508.model.Star;
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
        return jdbcTemplate.query("select s.*, p.name as projectName, p.studentId as projectStudentId from stars s, projects p where s.projectId = p.id and s.studentId = ?", new StarRowMapper(), studentId);
    }

}
