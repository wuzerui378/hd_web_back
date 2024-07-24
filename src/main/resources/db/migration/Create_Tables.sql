-- 创建 region_cluster_submit 表
CREATE TABLE region_cluster_submit (
                                       id INT AUTO_INCREMENT PRIMARY KEY,
                                       region_cluster_name VARCHAR(255) NOT NULL,
                                       region_crowd_type VARCHAR(255) NOT NULL,
                                       agent_id INT NOT NULL,
                                       status VARCHAR(255) NOT NULL,
                                       created_by VARCHAR(255) NOT NULL,
                                       updated_by VARCHAR(255) NOT NULL,
                                       create_time DATETIME NOT NULL,
                                       update_time DATETIME NOT NULL,
                                       clean_mark INT NOT NULL
);

-- 创建 customer_dto_list 表
CREATE TABLE customer_dto_list (
                                   id INT AUTO_INCREMENT PRIMARY KEY,
                                   region_cluster_id INT NOT NULL,
                                   customer_id INT NOT NULL,
                                   create_time DATETIME NOT NULL,
                                   agent_id INT NOT NULL,
                                   agent_name VARCHAR(255) NOT NULL,
                                   customer_mobile VARCHAR(20) NOT NULL,
                                   customer_fullname VARCHAR(255) NOT NULL
);

-- 创建 area_list 表
CREATE TABLE area_list (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           region_cluster_id INT NOT NULL,
                           area_id INT NOT NULL,
                           province_id INT NOT NULL,
                           province_name VARCHAR(255) NOT NULL,
                           city_id INT NOT NULL,
                           city_name VARCHAR(255) NOT NULL,
                           district_id INT NOT NULL,
                           district_name VARCHAR(255) NOT NULL,
                           created_by VARCHAR(255) NOT NULL,
                           updated_by VARCHAR(255) NOT NULL,
                           create_time DATETIME NOT NULL,
                           update_time DATETIME NOT NULL
);
