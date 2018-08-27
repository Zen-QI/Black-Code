/*
 Navicat MySQL Data Transfer

 Source Server         : MySQL3306
 Source Server Type    : MySQL
 Source Server Version : 50528
 Source Host           : localhost:3306
 Source Schema         : web

 Target Server Type    : MySQL
 Target Server Version : 50528
 File Encoding         : 65001

 Date: 28/08/2018 00:42:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer`  (
  `id` int(11) NOT NULL,
  `data1` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `data2` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `data3` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `data4` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `data5` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `answer1` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `answer2` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `answer3` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `answer4` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `answer5` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT `id` FOREIGN KEY (`id`) REFERENCES `questions` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of answer
-- ----------------------------
INSERT INTO `answer` VALUES (1, '2 6', '7 5', '3 5', '55 66', '2 44', '8', '12', '8', '121', '46');

-- ----------------------------
-- Table structure for questions
-- ----------------------------
DROP TABLE IF EXISTS `questions`;
CREATE TABLE `questions`  (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `test_data` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `test_answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `t_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of questions
-- ----------------------------
INSERT INTO `questions` VALUES (1, 'a+b', '输入A、B，输出A+B。\r\n输入的第一行包括两个整数，由空格分隔，分别表示A、B。\r\n输出一行，包括一个整数，表示A+B的值。', '12 45', '57', '');
INSERT INTO `questions` VALUES (2, '2a+b', '输入A、B，输出A+B。\r\n输入的第一行包括两个整数，由空格分隔，分别表示A、B。\r\n输出一行，包括一个整数，表示A+B的值。', '12 45', '57', '');
INSERT INTO `questions` VALUES (3, '3a+b', '输入A、B，输出A+B。\r\n输入的第一行包括两个整数，由空格分隔，分别表示A、B。\r\n输出一行，包括一个整数，表示A+B的值。', '12 45', '57', '');
INSERT INTO `questions` VALUES (4, '4a+b', '输入A、B，输出A+B。\r\n输入的第一行包括两个整数，由空格分隔，分别表示A、B。\r\n输出一行，包括一个整数，表示A+B的值。', '12 45', '57', '');
INSERT INTO `questions` VALUES (5, '5a+b', '输入A、B，输出A+B。\r\n输入的第一行包括两个整数，由空格分隔，分别表示A、B。\r\n输出一行，包括一个整数，表示A+B的值。', '12 45', '57', '');
INSERT INTO `questions` VALUES (6, 'a-b', '输入A、B，输出A-B。 输入的第一行包括两个整数，由空格分隔，分别表示A、B。 输出一行，包括一个整数，表示A-B的值。', '8 5', '3', 'T123456');
INSERT INTO `questions` VALUES (7, '2a-b', '输入A、B，输出A-B。 输入的第一行包括两个整数，由空格分隔，分别表示A、B。 输出一行，包括一个整数，表示A-B的值。', '8 5', '3', 'T123456');

-- ----------------------------
-- Table structure for submitlog
-- ----------------------------
DROP TABLE IF EXISTS `submitlog`;
CREATE TABLE `submitlog`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `s_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `data` datetime NULL,
  `code` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `q_id` int(11) NOT NULL,
  `type` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `test1` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `test2` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `test3` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `test4` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `test5` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `echo1` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `echo2` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `echo3` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `echo4` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `echo5` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of submitlog
-- ----------------------------
INSERT INTO `submitlog` VALUES (1, 'E21600096', '2017-10-22 00:00:00', '#include <iostream>\r\n \r\nusing namespace std;\r\n \r\nint main()\r\n{\r\n    int a, b;\r\n    cin >> a >> b;\r\n    cout << a + b;\r\n    return 0;\r\n}', 1, 'c++', 'true', 'true', 'true', 'true', 'true', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `submitlog` VALUES (2, 'E21600096', '2017-10-22 00:00:00', '#include <iostream>\r\n \r\nusing namespace std;\r\n \r\nint main()\r\n{\r\n    int a, b;\r\n    cin >> a >> b;\r\n    cout << a * b;\r\n    return 0;\r\n}', 1, 'c++', 'false', 'false', 'false', 'false', 'false', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `submitlog` VALUES (3, 'E21600096', '2017-10-22 00:00:00', '#include <iostream>\r\n \r\nusing namespace std;\r\n \r\nint main()\r\n{\r\n    int a, b;\r\n    cin >> a >> b;\r\n    cout << a * b;\r\n    return 0;\r\n}', 1, 'c++', 'false', 'false', 'false', 'false', 'false', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `submitlog` VALUES (4, 'E21600096', '2017-10-22 00:00:00', '#include <iostream>\r\n \r\nusing namespace std;\r\n \r\nint main()\r\n{\r\n    int a, b;\r\n    cin >> a >> b;\r\n    cout << a * b;\r\n    return 0;\r\n}', 1, 'c++', 'false', 'false', 'false', 'false', 'false', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `submitlog` VALUES (5, 'E21600096', '2017-10-22 00:00:00', '#include <iostream>\r\n \r\nusing namespace std;\r\n \r\nint main()\r\n{\r\n    int a, b;\r\n    cin >> a >> b;\r\n    cout << a * b;\r\n    return 0;\r\n}', 1, 'c++', 'false', 'false', 'false', 'false', 'false', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `submitlog` VALUES (6, 'E21600096', '2017-10-22 00:00:00', '#include <iostream>\r\n \r\nusing namespace std;\r\n \r\nint main()\r\n{\r\n    int a, b;\r\n    cin >> a >> b;\r\n    cout << a * b;\r\n    return 0;\r\n}', 1, 'c++', 'false', 'false', 'false', 'false', 'false', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `submitlog` VALUES (7, 'E21600096', '2017-10-22 00:00:00', '#include <iostream>\r\n \r\nusing namespace std;\r\n \r\nint main()\r\n{\r\n    int a, b;\r\n    cin >> a >> b;\r\n    cout << a * b;\r\n    return 0;\r\n}', 1, 'c++', 'false', 'false', 'false', 'false', 'false', '12', '35', '15', '3630', '88');
INSERT INTO `submitlog` VALUES (8, 'E21600096', '2017-10-22 15:06:25', '#include <iostream>\r\n \r\nusing namespace std;\r\n \r\nint main()\r\n{\r\n    int a, b;\r\n    cin >> a >> b;\r\n    cout << a * b;\r\n    return 0;\r\n}', 1, 'c++', 'false', 'false', 'false', 'false', 'false', '12', '35', '15', '3630', '88');
INSERT INTO `submitlog` VALUES (9, 'E21600096', '2017-10-22 15:51:02', 'import java.util.*;\r\n \r\npublic class Main\r\n{\r\n    public static void main(String args[])\r\n    {\r\n        Scanner sc = new Scanner(System.in);\r\n        Integer a = sc.nextInt();\r\n        Integer b = sc.nextInt();\r\n        System.out.println(a + b);\r\n    }\r\n}', 1, 'java', 'false', 'false', 'false', 'false', 'false', ': ?? java', ': ?? java', ': ?? java', ': ?? java', ': ?? java');
INSERT INTO `submitlog` VALUES (10, 'E21600096', '2017-10-22 15:51:10', 'import java.util.*;\r\n \r\npublic class java\r\n{\r\n    public static void main(String args[])\r\n    {\r\n        Scanner sc = new Scanner(System.in);\r\n        Integer a = sc.nextInt();\r\n        Integer b = sc.nextInt();\r\n        System.out.println(a + b);\r\n    }\r\n}', 1, 'java', 'false', 'false', 'false', 'false', 'false', ': ?? java', ': ?? java', ': ?? java', ': ?? java', ': ?? java');
INSERT INTO `submitlog` VALUES (11, 'E21600096', '2017-10-22 15:57:16', 'import java.util.*;\r\n \r\npublic class java\r\n{\r\n    public static void main(String args[])\r\n    {\r\n        Scanner sc = new Scanner(System.in);\r\n        Integer a = sc.nextInt();\r\n        Integer b = sc.nextInt();\r\n        System.out.println(a + b);\r\n    }\r\n}', 1, 'java', 'false', 'false', 'false', 'false', 'false', ': ?? java', ': ?? java', ': ?? java', ': ?? java', ': ?? java');
INSERT INTO `submitlog` VALUES (12, 'E21600096', '2017-10-22 16:02:24', 'import java.util.*;\r\n \r\npublic class java\r\n{\r\n    public static void main(String args[])\r\n    {\r\n        Scanner sc = new Scanner(System.in);\r\n        Integer a = sc.nextInt();\r\n        Integer b = sc.nextInt();\r\n        System.out.println(a + b);\r\n    }\r\n}', 1, 'java', 'false', 'false', 'false', 'false', 'false', '\'\'java\' ????????', '\'\'java\' ????????', '\'\'java\' ????????', '\'\'java\' ????????', '\'\'java\' ????????');
INSERT INTO `submitlog` VALUES (13, 'E21600096', '2017-10-22 16:02:41', 'import java.util.*;\r\n \r\npublic class java\r\n{\r\n    public static void main(String args[])\r\n    {\r\n        Scanner sc = new Scanner(System.in);\r\n        Integer a = sc.nextInt();\r\n        Integer b = sc.nextInt();\r\n        System.out.println(a + b);\r\n    }\r\n}', 1, 'java', 'false', 'false', 'false', 'false', 'false', '\'\'java\' ????????', '\'\'java\' ????????', '\'\'java\' ????????', '\'\'java\' ????????', '\'\'java\' ????????');
INSERT INTO `submitlog` VALUES (14, 'E21600096', '2017-10-22 16:02:46', 'import java.util.*;\r\n \r\npublic class java\r\n{\r\n    public static void main(String args[])\r\n    {\r\n        Scanner sc = new Scanner(System.in);\r\n        Integer a = sc.nextInt();\r\n        Integer b = sc.nextInt();\r\n        System.out.println(a + b);\r\n    }\r\n}', 1, 'java', 'false', 'false', 'false', 'false', 'false', '\'\'java\' ????????', '\'\'java\' ????????', '\'\'java\' ????????', '\'\'java\' ????????', '\'\'java\' ????????');
INSERT INTO `submitlog` VALUES (15, 'E21600096', '2017-10-22 16:02:54', 'import java.util.*;\r\n \r\npublic class java\r\n{\r\n    public static void main(String args[])\r\n    {\r\n        Scanner sc = new Scanner(System.in);\r\n        Integer a = sc.nextInt();\r\n        Integer b = sc.nextInt();\r\n        System.out.println(a + b);\r\n    }\r\n}', 1, 'java', 'false', 'false', 'false', 'false', 'false', '\'\'java\' ????????', '\'\'java\' ????????', '\'\'java\' ????????', '\'\'java\' ????????', '\'\'java\' ????????');
INSERT INTO `submitlog` VALUES (16, 'E21600096', '2017-10-22 16:03:01', 'import java.util.*;\r\n \r\npublic class java\r\n{\r\n    public static void main(String args[])\r\n    {\r\n        Scanner sc = new Scanner(System.in);\r\n        Integer a = sc.nextInt();\r\n        Integer b = sc.nextInt();\r\n        System.out.println(a + b);\r\n    }\r\n}', 1, 'java', 'false', 'false', 'false', 'false', 'false', '\'\'java\' ????????', '\'\'java\' ????????', '\'\'java\' ????????', '\'\'java\' ????????', '\'\'java\' ????????');
INSERT INTO `submitlog` VALUES (17, 'E21600096', '2017-10-22 16:03:08', 'import java.util.*;\r\n \r\npublic class java\r\n{\r\n    public static void main(String args[])\r\n    {\r\n        Scanner sc = new Scanner(System.in);\r\n        Integer a = sc.nextInt();\r\n        Integer b = sc.nextInt();\r\n        System.out.println(a + b);\r\n    }\r\n}', 1, 'java', 'false', 'false', 'false', 'false', 'false', '\'\'java\' ????????', '\'\'java\' ????????', '\'\'java\' ????????', '\'\'java\' ????????', '\'\'java\' ????????');
INSERT INTO `submitlog` VALUES (18, 'E21600096', '2017-10-22 16:03:49', 'import java.util.*;\r\n \r\npublic class java\r\n{\r\n    public static void main(String args[])\r\n    {\r\n        Scanner sc = new Scanner(System.in);\r\n        Integer a = sc.nextInt();\r\n        Integer b = sc.nextInt();\r\n        System.out.println(a + b);\r\n    }\r\n}', 1, 'java', 'false', 'false', 'false', 'false', 'false', ': ?? java', ': ?? java', ': ?? java', ': ?? java', ': ?? java');
INSERT INTO `submitlog` VALUES (19, 'E21600096', '2017-10-22 16:11:52', 'import java.util.*;\r\n \r\npublic class java\r\n{\r\n    public static void main(String args[])\r\n    {\r\n        Scanner sc = new Scanner(System.in);\r\n        Integer a = sc.nextInt();\r\n        Integer b = sc.nextInt();\r\n        System.out.println(a + b);\r\n    }\r\n}', 1, 'java', 'false', 'false', 'false', 'false', 'false', ': ?? java', ': ?? java', ': ?? java', ': ?? java', ': ?? java');
INSERT INTO `submitlog` VALUES (20, 'E21600096', '2017-10-22 16:12:30', '#include <iostream>\r\n \r\nusing namespace std;\r\n \r\nint main()\r\n{\r\n    int a, b;\r\n    cin >> a >> b;\r\n    cout << a + b;\r\n    return 0;\r\n}', 1, 'c++', 'false', 'false', 'false', 'false', 'false', '\'D:\\test\\cpp.exe\' ????????', '\'D:\\test\\cpp.exe\' ????????', '\'D:\\test\\cpp.exe\' ????????', '\'D:\\test\\cpp.exe\' ????????', '\'D:\\test\\cpp.exe\' ????????');
INSERT INTO `submitlog` VALUES (21, 'E21600096', '2017-10-22 16:13:06', '#include <iostream>\r\n \r\nusing namespace std;\r\n \r\nint main()\r\n{\r\n    int a, b;\r\n    cin >> a >> b;\r\n    cout << a + b;\r\n    return 0;\r\n}', 1, 'c++', 'true', 'true', 'true', 'true', 'true', '8', '12', '8', '121', '46');
INSERT INTO `submitlog` VALUES (22, 'E21600096', '2017-10-22 16:13:47', '#include <iostream>\r\n \r\nusing namespace std;\r\n \r\nint main()\r\n{\r\n    int a, b;\r\n    cin >> a >> b;\r\n    cout << a + b;\r\n    return 0;\r\n}', 1, 'c++', 'true', 'true', 'true', 'true', 'true', '8', '12', '8', '121', '46');
INSERT INTO `submitlog` VALUES (23, 'E21600096', '2017-10-22 16:14:02', '#include <stdio.h>\r\n \r\nint main()\r\n{\r\n    int a, b;\r\n    scanf(\"%d%d\", &a, &b);\r\n    printf(\"%d\", a+b);\r\n    return 0;\r\n}', 1, 'c', 'false', 'false', 'false', 'false', 'false', '\'D:\\test\\c.exe\' ????????', '\'D:\\test\\c.exe\' ????????', '\'D:\\test\\c.exe\' ????????', '\'D:\\test\\c.exe\' ????????', '\'D:\\test\\c.exe\' ????????');
INSERT INTO `submitlog` VALUES (24, 'E21600096', '2017-10-22 16:28:29', '#include <stdio.h>\r\n \r\nint main()\r\n{\r\n    int a, b;\r\n    scanf(\"%d%d\", &a, &b);\r\n    printf(\"%d\", a+b);\r\n    return 0;\r\n}', 1, 'c', 'true', 'true', 'true', 'true', 'true', '8', '12', '8', '121', '46');
INSERT INTO `submitlog` VALUES (25, 'E21600096', '2017-10-22 16:28:46', '#include <stdio.h>\r\n \r\nint main()\r\n{\r\n    int a, b;\r\n    scanf(\"%d%d\", &a, &b);\r\n    printf(\"%d\", a+b);\r\n    return 0;\r\n}', 1, 'c', 'true', 'true', 'true', 'true', 'true', '8', '12', '8', '121', '46');
INSERT INTO `submitlog` VALUES (26, 'E21600096', '2017-10-22 16:33:12', 'import java.util.*;\r\n \r\npublic class Main\r\n{\r\n    public static void main(String args[])\r\n    {\r\n        Scanner sc = new Scanner(System.in);\r\n        Integer a = sc.nextInt();\r\n        Integer b = sc.nextInt();\r\n        System.out.println(a + b);\r\n    }\r\n}', 1, 'java', 'false', 'false', 'false', 'false', 'false', ': ?? java', ': ?? java', ': ?? java', ': ?? java', ': ?? java');
INSERT INTO `submitlog` VALUES (27, 'E21600096', '2017-10-22 16:36:07', 'import java.util.*;\r\n \r\npublic class Main\r\n{\r\n    public static void main(String args[])\r\n    {\r\n        Scanner sc = new Scanner(System.in);\r\n        Integer a = sc.nextInt();\r\n        Integer b = sc.nextInt();\r\n        System.out.println(a + b);\r\n    }\r\n}', 1, 'java', 'false', 'false', 'false', 'false', 'false', ': ?? java', ': ?? java', ': ?? java', ': ?? java', ': ?? java');
INSERT INTO `submitlog` VALUES (28, 'E21600096', '2017-10-23 09:37:59', 'import java.util.*;\r\n \r\npublic class java\r\n{\r\n    public static void main(String args[])\r\n    {\r\n        Scanner sc = new Scanner(System.in);\r\n        Integer a = sc.nextInt();\r\n        Integer b = sc.nextInt();\r\n        System.out.println(a + b);\r\n    }\r\n}', 1, 'java', 'false', 'false', 'false', 'false', 'false', ': ?? java', ': ?? java', ': ?? java', ': ?? java', ': ?? java');
INSERT INTO `submitlog` VALUES (29, 'E21600096', '2017-10-23 09:38:50', 'import java.util.*;\r\n \r\npublic class java\r\n{\r\n    public static void main(String args[])\r\n    {\r\n        Scanner sc = new Scanner(System.in);\r\n        Integer a = sc.nextInt();\r\n        Integer b = sc.nextInt();\r\n        System.out.println(a + b);\r\n    }\r\n}', 1, 'java', 'false', 'false', 'false', 'false', 'false', ': ?? java', ': ?? java', ': ?? java', ': ?? java', ': ?? java');
INSERT INTO `submitlog` VALUES (30, 'E21600096', '2017-10-23 10:04:32', 'import java.util.*;\r\n \r\npublic class java\r\n{\r\n    public static void main(String args[])\r\n    {\r\n        Scanner sc = new Scanner(System.in);\r\n        Integer a = sc.nextInt();\r\n        Integer b = sc.nextInt();\r\n        System.out.println(a + b);\r\n    }\r\n}', 1, 'java', 'false', 'false', 'false', 'false', 'false', ': ?? java', ': ?? java', ': ?? java', ': ?? java', ': ?? java');
INSERT INTO `submitlog` VALUES (31, 'E21600096', '2017-10-23 10:22:50', 'import java.util.*;\r\n \r\npublic class java\r\n{\r\n    public static void main(String args[])\r\n    {\r\n        Scanner sc = new Scanner(System.in);\r\n        Integer a = sc.nextInt();\r\n        Integer b = sc.nextInt();\r\n        System.out.println(a + b);\r\n    }\r\n}', 1, 'java', 'false', 'false', 'false', 'false', 'false', 'D:\\test>java java : ?? java', 'D:\\test>java java : ?? java', 'D:\\test>java java : ?? java', 'D:\\test>java java : ?? java', 'D:\\test>java java : ?? java');
INSERT INTO `submitlog` VALUES (32, 'E21600096', '2017-10-23 10:23:55', 'import java.util.*;\r\n \r\npublic class java\r\n{\r\n    public static void main(String args[])\r\n    {\r\n        Scanner sc = new Scanner(System.in);\r\n        Integer a = sc.nextInt();\r\n        Integer b = sc.nextInt();\r\n        System.out.println(a + b);\r\n    }\r\n}', 1, 'java', 'false', 'false', 'false', 'false', 'false', 'D:\\test>set CLASSPATH=D:\\test D:\\test>java java 8', 'D:\\test>set CLASSPATH=D:\\test D:\\test>java java 12', 'D:\\test>set CLASSPATH=D:\\test D:\\test>java java 8', 'D:\\test>set CLASSPATH=D:\\test D:\\test>java java 121', 'D:\\test>set CLASSPATH=D:\\test D:\\test>java java 46');
INSERT INTO `submitlog` VALUES (33, 'E21600096', '2017-10-23 10:26:15', 'import java.util.*;\r\n \r\npublic class java\r\n{\r\n    public static void main(String args[])\r\n    {\r\n        Scanner sc = new Scanner(System.in);\r\n        Integer a = sc.nextInt();\r\n        Integer b = sc.nextInt();\r\n        System.out.println(a + b);\r\n    }\r\n}', 1, 'java', 'false', 'false', 'false', 'false', 'false', 'D:\\test>set CLASSPATH=D:\\test D:\\test>java java 8', 'D:\\test>set CLASSPATH=D:\\test D:\\test>java java 12', 'D:\\test>set CLASSPATH=D:\\test D:\\test>java java 8', 'D:\\test>set CLASSPATH=D:\\test D:\\test>java java 121', 'D:\\test>set CLASSPATH=D:\\test D:\\test>java java 46');
INSERT INTO `submitlog` VALUES (34, 'E21600096', '2017-12-04 16:38:19', 'import java.util.Scanner;\r\n\r\n/*\r\n * To change this license header, choose License Headers in Project Properties.\r\n * To change this template file, choose Tools | Templates\r\n * and open the template in the editor.\r\n */\r\n\r\n/**\r\n *\r\n * @author black\r\n */\r\npublic class Java{\r\n    public static void main(String[] args) {\r\n	Scanner sc = new Scanner(System.in);\r\n	int a = sc.nextInt(),b = sc.nextInt();\r\n	System.out.println(a+b);\r\n    }\r\n}', 1, 'java', 'true', 'true', 'true', 'true', 'true', '8', '12', '8', '121', '46');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '学号或工号' COMMENT '帐号',
  `pass` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type` int(1) NULL DEFAULT NULL COMMENT '1为老师，0或空为学生',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('A21600096', '123', '张三', 0);
INSERT INTO `user` VALUES ('E21600096', '123', '李四', 0);
INSERT INTO `user` VALUES ('T123456', '123', '王麻子', 1);
INSERT INTO `user` VALUES ('T654321', '123', '李麻子', 1);

SET FOREIGN_KEY_CHECKS = 1;
