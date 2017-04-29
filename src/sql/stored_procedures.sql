DROP PROCEDURE IF EXISTS user_activity_feed;

DELIMITER //
CREATE PROCEDURE user_activity_feed
(IN user_id INTEGER(10))
BEGIN
    select a.type, a.studentId, s.name, pa_a.projectId as targetId, a.created_at from activity_feed_items fi, activities a, project_added_activities pa_a, students s
    where fi.activityId = a.id
    and fi.studentId = user_id
    and type = 'project_added'
    and s.id = a.studentId
    and a.id = pa_a.id

    union all

    select a.type, a.studentId, s.name, pu_a.projectId as targetId, a.created_at from activity_feed_items fi, activities a, project_updated_activities pu_a, students s
    where fi.activityId = a.id
    and fi.studentId = user_id
    and type = 'project_updated'
    and s.id = a.studentId
    and a.id = pu_a.id

    union all

    select a.type, a.studentId, s.name, e_a.courseId as targetId, a.created_at from activity_feed_items fi, activities a, enrolled_activities e_a, students s
    where fi.activityId = a.id
    and fi.studentId = user_id
    and type = 'enrolled'
    and s.id = a.studentId
    and a.id = e_a.id

    union all

    select a.type, a.studentId, s.name, c_a.commentId as targetId, a.created_at from activity_feed_items fi, activities a, comment_activities c_a, students s
    where fi.activityId = a.id
    and fi.studentId = user_id
    and type = 'comment'
    and s.id = a.studentId
    and a.id = c_a.id

    order by created_at desc

    limit 5;
END //
DELIMITER ;