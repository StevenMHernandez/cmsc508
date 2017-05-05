package com.cmsc508.repository;

import com.cmsc508.model.Comment;
import com.cmsc508.rowmapper.CommentRowMapper;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CommentsRepository extends BaseRepository {
    public CommentsRepository(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    private static Integer PROJECT_TYPE = 1;
    private static Integer STUDENT_TYPE = 2;

    public void addForProject(Integer project_id, Long student_id, String comment) {
        jdbcTemplate.update("insert into comments (studentId, type, targetId, body) VALUES (?,?,?,?)", new Object[]{student_id, PROJECT_TYPE, project_id, comment});
    }

    public List<Comment> findForProject(Integer project_id) {
        return jdbcTemplate.query("select c.*, s.name as 'studentName' from comments c, students s where c.studentId = s.id and c.type = ? and c.targetId = ? order by created_at desc", new Object[]{PROJECT_TYPE, project_id}, new CommentRowMapper());
    }
}
