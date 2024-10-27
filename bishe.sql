/*
 Navicat Premium Data Transfer

 Source Server         : 阿里云
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : kaodigua.mysql.polardb.rds.aliyuncs.com:3306
 Source Schema         : bishe

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 25/04/2024 12:46:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'id主键',
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `sex` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('admin', '123456', '赵五', 35, '男', '13976144190');

-- ----------------------------
-- Table structure for dorm_build
-- ----------------------------
DROP TABLE IF EXISTS `dorm_build`;
CREATE TABLE `dorm_build`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dormbuild_id` int(11) NOT NULL COMMENT '宿舍楼号码',
  `dormbuild_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '宿舍楼名称',
  `dormbuild_detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '宿舍楼备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dorm_build
-- ----------------------------
INSERT INTO `dorm_build` VALUES (1, 1, '一号楼', '男宿舍');
INSERT INTO `dorm_build` VALUES (2, 2, '二号楼', '女宿舍');
INSERT INTO `dorm_build` VALUES (3, 3, '三号楼', '男宿舍');
INSERT INTO `dorm_build` VALUES (4, 4, '四号楼', '女宿舍');

-- ----------------------------
-- Table structure for dorm_manager
-- ----------------------------
DROP TABLE IF EXISTS `dorm_manager`;
CREATE TABLE `dorm_manager`  (
  `id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '123456' COMMENT '密码',
  `dormbuild_id` int(11) NOT NULL COMMENT '所管理的宿舍楼栋号',
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名字',
  `sex` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '性别',
  `age` int(2) NOT NULL COMMENT '年龄',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dorm_manager
-- ----------------------------
INSERT INTO `dorm_manager` VALUES ('dorm1', '123456', 1, '张三', '男', 35, '15222223333');
INSERT INTO `dorm_manager` VALUES ('dorm2', '123456', 2, '李四', '女', 55, '15333332222');
INSERT INTO `dorm_manager` VALUES ('dorm3', '123456', 3, '王五', '男', 38, '15855552222');
INSERT INTO `dorm_manager` VALUES ('dorm4', '123456', 4, '赵花', '女', 40, '15877776666');
INSERT INTO `dorm_manager` VALUES ('Mtest', '123456', 2, '宿管测试', '男', 22, '15899999999');

-- ----------------------------
-- Table structure for dorm_room
-- ----------------------------
DROP TABLE IF EXISTS `dorm_room`;
CREATE TABLE `dorm_room`  (
  `dormroom_id` int(11) NOT NULL COMMENT '宿舍房间号',
  `dormbuild_id` int(11) NOT NULL COMMENT '宿舍楼号',
  `floor_num` int(11) NOT NULL COMMENT '楼层',
  `max_capacity` int(11) NOT NULL DEFAULT 4 COMMENT '房间最大入住人数',
  `current_capacity` int(11) NOT NULL DEFAULT 0 COMMENT '当前房间入住人数',
  PRIMARY KEY (`dormroom_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dorm_room
-- ----------------------------
INSERT INTO `dorm_room` VALUES (1101, 1, 1, 4, 3);
INSERT INTO `dorm_room` VALUES (1102, 1, 1, 4, 4);
INSERT INTO `dorm_room` VALUES (1103, 1, 1, 4, 4);
INSERT INTO `dorm_room` VALUES (1201, 1, 2, 4, 2);
INSERT INTO `dorm_room` VALUES (2101, 2, 1, 4, 4);
INSERT INTO `dorm_room` VALUES (2102, 2, 1, 4, 3);
INSERT INTO `dorm_room` VALUES (2201, 2, 2, 4, 2);
INSERT INTO `dorm_room` VALUES (2202, 2, 2, 4, 1);
INSERT INTO `dorm_room` VALUES (3101, 3, 1, 4, 4);
INSERT INTO `dorm_room` VALUES (3102, 3, 1, 4, 3);
INSERT INTO `dorm_room` VALUES (3536, 3, 5, 4, 4);
INSERT INTO `dorm_room` VALUES (3636, 5, 6, 4, 3);
INSERT INTO `dorm_room` VALUES (4101, 4, 1, 4, 2);
INSERT INTO `dorm_room` VALUES (4102, 4, 1, 4, 2);
INSERT INTO `dorm_room` VALUES (4201, 4, 2, 4, 1);
INSERT INTO `dorm_room` VALUES (4202, 4, 2, 4, 1);
INSERT INTO `dorm_room` VALUES (4301, 4, 3, 4, 2);
INSERT INTO `dorm_room` VALUES (4302, 4, 3, 4, 1);

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `text` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (1, '停水告示', '<p>停水一天</p>', '2024-02-24 00:00:00');
INSERT INTO `notice` VALUES (2, '停电告示', '<p>停电半天</p>', '2024-02-25 00:00:00');
INSERT INTO `notice` VALUES (3, '路灯维修', '<p>维修走廊的路灯</p>', '2024-02-26 00:00:00');
INSERT INTO `notice` VALUES (4, '风扇维修', '<p>白天请勿锁门，维修师傅进宿舍换新风扇</p>', '2024-02-28 00:00:00');
INSERT INTO `notice` VALUES (5, '关于放假宿舍处理', '<p>放假后宿舍不允许居住，请尽快搬离</p>', '2024-02-29 00:00:00');

-- ----------------------------
-- Table structure for repair
-- ----------------------------
DROP TABLE IF EXISTS `repair`;
CREATE TABLE `repair`  (
  `order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `sid` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '报修人id',
  `sname` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报修人电话',
  `sphone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报修人姓名',
  `dormbuild_id` int(11) NOT NULL COMMENT '报修宿舍楼',
  `dormroom_id` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '报修宿舍房间号',
  `wid` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维修员',
  `wname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维修员姓名',
  `wphone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维修员电话',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维修类型',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '表单内容',
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单状态（是否维修完成）',
  `order_buildtime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '订单创建时间',
  `order_finishtime` datetime(0) NULL DEFAULT NULL COMMENT '订单完成时间',
  `finish` int(255) NULL DEFAULT NULL,
  `evaluate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评价',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of repair
-- ----------------------------
INSERT INTO `repair` VALUES (4, '0912200201', '彭小浩', '13976144100', 1, '1101', '0001', '张三', '14534637016', '水热水器及配套', '热水器不出热水', '完成', '2024-04-13 00:37:50', '2024-04-13 00:43:57', 1, NULL);
INSERT INTO `repair` VALUES (5, '0912200201', '彭小浩', '13976144100', 1, '1101', '0001', '张三', '14534637016', '水热水器及配套', '坏了', '未完成', '2024-04-13 10:31:15', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `sex` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `dormbuild_id` int(11) NULL DEFAULT NULL,
  `dormroom_id` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `flag` tinyint(4) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('0912200101', '123456', '李四', 22, '男', '13976144190', 1, '1101', 1);
INSERT INTO `student` VALUES ('0912200201', '123456', '彭小浩', 20, '男', '13976144100', 1, '1101', 1);
INSERT INTO `student` VALUES ('0912200202', '123456', '番薯', 22, '男', '13976144101', 1, '1101', 1);
INSERT INTO `student` VALUES ('0912200203', '123456', '陈荣轩', 22, '女', '15264765701', 1, '1102', 1);
INSERT INTO `student` VALUES ('0912200204', '123456', '贾立辉', 22, '女', '18683679181', 1, '1102', 1);
INSERT INTO `student` VALUES ('0912200205', '123456', '林黎昕', 22, '男', '14789913862', 1, '1102', 1);
INSERT INTO `student` VALUES ('0912200206', '123456', '郝弘文', 22, '男', '15229035279', 1, '1102', 1);
INSERT INTO `student` VALUES ('0912200207', '123456', '孟涛', 22, '女', '15921754842', 1, '1102', 1);
INSERT INTO `student` VALUES ('0912200208', '123456', '徐昊强', 22, '女', '15583564415', 1, '1103', 1);
INSERT INTO `student` VALUES ('0912200209', '123456', '阎文轩', 22, '女', '13957770973', 1, '1103', 1);
INSERT INTO `student` VALUES ('0912200210', '123456', '覃鹏涛', 22, '男', '17605699371', 1, '1201', 1);
INSERT INTO `student` VALUES ('0912200211', '123456', '袁鹏', 22, '女', '17375536725', 1, '1201', 1);
INSERT INTO `student` VALUES ('0912200212', '123456', '邵修杰', 22, '男', '13418370296', 2, '2101', 1);
INSERT INTO `student` VALUES ('0912200213', '123456', '蒋俊驰', 22, '女', '15371429166', 2, '2101', 1);
INSERT INTO `student` VALUES ('0912200214', '123456', '段烨华', 22, '男', '15333997319', 2, '2101', 1);
INSERT INTO `student` VALUES ('0912200215', '123456', '王弘文', 22, '男', '15535247326', 2, '2101', 1);
INSERT INTO `student` VALUES ('0912200216', '123456', '洪修洁', 22, '女', '15596722500', 2, '2102', 1);
INSERT INTO `student` VALUES ('0912200217', '123456', '王绍齐', 23, '男', '15925538545', 2, '2102', 1);
INSERT INTO `student` VALUES ('0912200218', '123456', '白浩宇', 22, '男', '15731214890', 2, '2102', 1);
INSERT INTO `student` VALUES ('0912200219', '123456', '蒋鹏', 21, '男', '15959015973', 2, '2201', 1);
INSERT INTO `student` VALUES ('0912200220', '123456', '龚修杰', 22, '女', '17021481785', 2, '2201', 1);
INSERT INTO `student` VALUES ('0912200221', '123456', '任俊驰', 22, '女', '17094581186', 2, '2202', 1);
INSERT INTO `student` VALUES ('0912200222', '123456', '余瑞霖', 22, '女', '18356646479', 3, '3101', 1);
INSERT INTO `student` VALUES ('0912200223', '123456', '梁天翊', 22, '男', '15009674311', 3, '3101', 1);
INSERT INTO `student` VALUES ('0912200224', '123456', '贾君浩', 22, '女', '17198260625', 3, '3101', 1);
INSERT INTO `student` VALUES ('0912200225', '123456', '秦航', 22, '男', '15723716023', 3, '3101', 1);
INSERT INTO `student` VALUES ('0912200226', '123456', '石鸿煊', 22, '女', '13741074140', 3, '3102', 1);
INSERT INTO `student` VALUES ('0912200227', '123456', '戴天宇', 22, '女', '15994058478', 3, '3102', 1);
INSERT INTO `student` VALUES ('0912200228', '123456', '董昊强', 22, '女', '15148864904', 3, '3102', 1);
INSERT INTO `student` VALUES ('0912200229', '123456', '金昊强', 22, '女', '17252635709', 3, '3536', 1);
INSERT INTO `student` VALUES ('0912200230', '123456', '杨志泽', 22, '男', '17132393751', 3, '3536', 1);
INSERT INTO `student` VALUES ('0912200231', '123456', '陈懿轩', 22, '男', '15558530352', 3, '3536', 1);
INSERT INTO `student` VALUES ('0912200232', '123456', '吕峻熙', 22, '女', '15313212134', 3, '3536', 1);
INSERT INTO `student` VALUES ('0912200233', '123456', '雷哲瀚', 22, '女', '15222631917', 3, '3636', 1);
INSERT INTO `student` VALUES ('0912200234', '123456', '邹晟睿', 22, '男', '15289906074', 3, '3636', 1);
INSERT INTO `student` VALUES ('0912200235', '123456', '蔡文轩', 22, '男', '15993664683', 4, '4101', 1);
INSERT INTO `student` VALUES ('0912200236', '123456', '龙晋鹏', 22, '女', '17249142891', 4, '4101', 1);
INSERT INTO `student` VALUES ('0912200237', '123456', '方梓晨', 20, '男', '17068371725', 4, '4102', 1);
INSERT INTO `student` VALUES ('0912200238', '123456', '彭楷瑞', 22, '男', '17014247411', 4, '4102', 1);
INSERT INTO `student` VALUES ('0912200239', '123456', '夏瑾瑜', 22, '男', '17822304575', 4, '4201', 1);
INSERT INTO `student` VALUES ('0912200240', '123456', '范果', 20, '男', '17341274740', 4, '4202', 1);
INSERT INTO `student` VALUES ('0912200241', '123456', '侯语堂', 22, '男', '15514496877', 4, '4301', 1);
INSERT INTO `student` VALUES ('0912200242', '123456', '江明', 22, '女', '17081469792', 4, '4302', 1);
INSERT INTO `student` VALUES ('0912200243', '123456', '白越彬', 22, '男', '15188646544', 4, '4301', 1);

-- ----------------------------
-- Table structure for worker
-- ----------------------------
DROP TABLE IF EXISTS `worker`;
CREATE TABLE `worker`  (
  `id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sex` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `flag` int(11) NULL DEFAULT 1,
  `repair_num` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of worker
-- ----------------------------
INSERT INTO `worker` VALUES ('0001', '14534637016', '123456', '张三', '男', 30, 1, -1);
INSERT INTO `worker` VALUES ('0002', '15020437526', '123456', '李四', '男', 28, 1, 0);
INSERT INTO `worker` VALUES ('0003', '15840585202', '123456', '王五', '男', 35, 1, 0);
INSERT INTO `worker` VALUES ('0004', '18024586885', '123456', '田七', '男', 27, 1, 0);
INSERT INTO `worker` VALUES ('0005', '17636916818', '123456', '李九', '男', 29, 1, 0);

SET FOREIGN_KEY_CHECKS = 1;
