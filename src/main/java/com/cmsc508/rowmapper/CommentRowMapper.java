package com.cmsc508.rowmapper;

import com.cmsc508.model.Comment;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentRowMapper implements RowMapper<Comment> {
    @Override
    public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Comment comment = new Comment();
        comment.setId(rs.getLong("id"));
        comment.setStudentId(rs.getInt("studentId"));
        comment.setType(rs.getInt("type"));
        comment.setTargetId(rs.getInt("targetId"));
        comment.setBody(rs.getString("body"));
        comment.setCreatedAt(rs.getDate("created_at"));
        comment.setUpdatedAt(rs.getDate("updated_at"));
        comment.setUpdatedAt(rs.getDate("updated_at"));
        comment.setStudentName(rs.getString("studentName"));
        return comment;
    }
}