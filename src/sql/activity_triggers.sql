-- comment_activities
DROP TRIGGER IF EXISTS add_comment_activity;
delimiter /
CREATE TRIGGER add_comment_activity AFTER INSERT ON comments
  FOR EACH ROW
  BEGIN
  	-- add an activity for this event
    INSERT INTO activities (type, studentId, created_at, updated_at) VALUES ("comment", NEW.studentId, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
    -- add the activity details for this event
    INSERT INTO comment_activities (id, commentId) VALUES (LAST_INSERT_ID(), NEW.id);
    -- `broadcast` the activity out to relevant activity_feeds
    INSERT INTO activity_feed_items (studentId, activityId) (
    	SELECT id, LAST_INSERT_ID() FROM comments c
		WHERE c.targetId = NEW.targetId
  		AND c.studentId != NEW.studentId
    );
    IF (NEW.type = 1) THEN
    	-- `broadcast` to project owner
    	INSERT INTO activity_feed_items (studentId, activityId) (
    		SELECT studentId, LAST_INSERT_ID() FROM projects p
    		WHERE p.id = NEW.targetId
    	);
    ELSE
    	-- `broadcast` to student
    	INSERT INTO activity_feed_items (studentId, activityId) VALUES (NEW.targetId, LAST_INSERT_ID());
    END IF;
  END;
/
delimiter ;
-- enrolled_activities
DROP TRIGGER IF EXISTS add_enrolled_activity;
delimiter /
CREATE TRIGGER add_enrolled_activity AFTER INSERT ON course_student
  FOR EACH ROW
  BEGIN
  	-- add an activity for this event
    INSERT INTO activities (type, studentId, created_at, updated_at) VALUES ("enrolled", NEW.studentId, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
    -- add the activity details for this event
    INSERT INTO enrolled_activities (id, studentId, courseId) VALUES (LAST_INSERT_ID(), NEW.studentId, NEW.courseId);
    -- `broadcast` the activity out to relevant activity_feeds
    INSERT INTO activity_feed_items (studentId, activityId) (
    	SELECT s.id, LAST_INSERT_ID() FROM students s, course_student cs
		  WHERE s.id = cs.studentId
  		AND s.id != NEW.studentId
    );
  END;
/
delimiter ;
-- project_added_activity
DROP TRIGGER IF EXISTS add_project_added_activity;
delimiter /
CREATE TRIGGER add_project_added_activity AFTER INSERT ON projects
  FOR EACH ROW
  BEGIN
  	-- add an activity for this event
    INSERT INTO activities (type, studentId, created_at, updated_at) VALUES ("project_added", NEW.studentId, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
    -- add the activity details for this event
    INSERT INTO project_added_activities (id, projectId) VALUES (LAST_INSERT_ID(), NEW.id);
    -- `broadcast` the activity out to relevant activity_feeds
    INSERT INTO activity_feed_items (studentId, activityId) (
    	SELECT s.id, LAST_INSERT_ID() FROM students s, course_student cs
		  WHERE s.id = cs.studentId
  		AND s.id != NEW.studentId
    );
  END;
/
delimiter ;
-- project_updated_activity
DROP TRIGGER IF EXISTS add_project_updated_activity;
delimiter /
CREATE TRIGGER add_project_updated_activity AFTER UPDATE ON projects
  FOR EACH ROW
  BEGIN
  	-- add an activity for this event
    INSERT INTO activities (type, studentId, created_at, updated_at) VALUES ("project_updated", NEW.studentId, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
    -- add the activity details for this event
    INSERT INTO project_updated_activities (id, projectId) VALUES (LAST_INSERT_ID(), NEW.id);
    -- `broadcast` the activity out to relevant activity_feeds
    INSERT INTO activity_feed_items (studentId, activityId) (
    	SELECT s.id, LAST_INSERT_ID() FROM students s, course_student cs
		  WHERE s.id = cs.studentId
  		AND s.id != NEW.studentId
    );
  END
/
delimiter ;
-- project_deleted_activity
DROP TRIGGER IF EXISTS add_project_updated_activity;
delimiter /
CREATE TRIGGER add_project_updated_activity BEFORE DELETE ON projects
  FOR EACH ROW
  BEGIN
  	CALL delete_activities_for_project(OLD.id);
  END
/
delimiter ;