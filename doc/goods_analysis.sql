/*
 Navicat Premium Data Transfer

 Source Server         : ZZH
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : goods_analysis

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 12/06/2023 21:08:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for beer
-- ----------------------------
DROP TABLE IF EXISTS `beer`;
CREATE TABLE `beer`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `brand` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '品牌',
  `name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品名称',
  `series` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '系列',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '啤酒商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of beer
-- ----------------------------
INSERT INTO `beer` VALUES ('1', '其他', '菠萝啤整箱装 24罐*320ml零酒精果啤果味汽水碳酸饮料夏日饮品', '其他', '2023-06-12 16:04:10', '2023-06-12 16:13:59');
INSERT INTO `beer` VALUES ('2', '雪花', 'SNOW雪花纯生啤酒8度500ml*12罐匠心营造易拉罐装整箱黄啤酒 500mL*12瓶', '清爽', '2023-06-12 16:04:34', '2023-06-12 18:14:28');
INSERT INTO `beer` VALUES ('3', '雪花', '雪花啤酒8°清爽啤酒330ml*24听 罐装整箱麦芽酿制 武汉满百包邮', '雪花其他', '2023-06-12 16:04:58', '2023-06-12 18:57:52');
INSERT INTO `beer` VALUES ('4', '雪花', '\r\n雪花（SNOW）啤酒  淡爽  500ml*12听  整箱装  送礼自饮佳品', '淡爽', '2023-06-12 16:05:12', '2023-06-12 20:07:55');
INSERT INTO `beer` VALUES ('5', '迷失海岸', '进口精酿啤酒迷失海岸花生酱牛奶世涛卡斯四料特浓巧克力组合装', '花生巧克力牛奶世涛', '2023-06-12 16:05:39', '2023-06-12 20:07:55');
INSERT INTO `beer` VALUES ('6', '迷失海岸', '\r\n迷失海岸美国进口精酿啤酒巧克力牛奶花生酱迷雾快艇幽灵浑浊IPA美国原装进口 17种口味可选 355ml 单瓶', '花生巧克力牛奶世涛', '2023-06-12 16:06:09', '2023-06-12 20:07:55');
INSERT INTO `beer` VALUES ('7', '海妖精酿', '海妖精酿啤酒瓶装比利时小麦白啤330ml12瓶包邮', '海妖精酿其他', '2023-06-12 16:06:27', '2023-06-12 20:07:55');

-- ----------------------------
-- Table structure for beer_series_map
-- ----------------------------
DROP TABLE IF EXISTS `beer_series_map`;
CREATE TABLE `beer_series_map`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `brand` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '品牌',
  `first_key` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '第一关键字',
  `second_key` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '第二关键字',
  `third_key` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '第三关键字',
  `fourth_key` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '第四关键字',
  `result` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '映射值',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '映射字典' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of beer_series_map
-- ----------------------------
INSERT INTO `beer_series_map` VALUES ('1', '雪花', '8度', '8°', NULL, NULL, '清爽', '2023-06-06 17:29:02', '2023-06-06 17:29:55');
INSERT INTO `beer_series_map` VALUES ('2', '迷失海岸', '花生巧克力牛奶世涛', '花生', '巧克力', '牛奶', '花生巧克力牛奶世涛', '2023-06-06 17:29:07', '2023-06-12 18:04:40');
INSERT INTO `beer_series_map` VALUES ('3', '海妖精酿', '海妖之泪', NULL, NULL, NULL, '海妖之泪', '2023-06-06 17:29:13', '2023-06-06 17:31:35');
INSERT INTO `beer_series_map` VALUES ('4', '雪花', '淡爽', NULL, NULL, NULL, '淡爽', '2023-06-12 16:35:41', '2023-06-12 16:35:41');

SET FOREIGN_KEY_CHECKS = 1;
