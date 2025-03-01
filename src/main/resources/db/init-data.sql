INSERT INTO sys_user (
  user_name, 
  nick_name, 
  password, 
  status, 
  create_by, 
  create_time, 
  update_by, 
  update_time, 
  remark
) VALUES (
  'admin', 
  '管理员', 
  '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', 
  '0', 
  'admin', 
  sysdate(), 
  'admin', 
  sysdate(), 
  '管理员'
);

-- 初始角色
INSERT INTO sys_role(
  role_name, 
  role_key, 
  role_sort, 
  status, 
  create_by, 
  create_time, 
  remark
) VALUES(
  '超级管理员', 
  'admin', 
  1, 
  '0', 
  'admin', 
  sysdate(), 
  '超级管理员'
);

-- 初始菜单
INSERT INTO sys_menu(
  menu_name, 
  parent_id, 
  order_num, 
  path, 
  component, 
  is_frame, 
  menu_type, 
  visible, 
  status, 
  perms, 
  icon, 
  create_by, 
  create_time, 
  remark
) VALUES(
  '系统管理', 
  0, 
  1, 
  'system', 
  null, 
  '1', 
  'M', 
  '0', 
  '0', 
  '', 
  'system', 
  'admin', 
  sysdate(), 
  '系统管理目录'
);

-- 用户角色关联
INSERT INTO sys_user_role(user_id, role_id) 
SELECT u.user_id, r.role_id
FROM sys_user u, sys_role r
WHERE u.user_name = 'admin' AND r.role_key = 'admin'; 