# Study_java_6.MySql
## Sql基础
### 1、NoSql和Sql的区别
    NoSQL（非关系型数据库）和SQL（关系型数据库）是两种常见的数据库类型，它们在功能和用途上有所不同。
    -SQL数据库是一种关系型数据库管理系统，它使用结构化查询语言（Structured Query Language，SQL）来管理数据。SQL数据库以表格的形式存储数据，每个表格都有特定的字段和数据类型。
    这些数据以行列二维表的形式存在，每一列代表数据的一种属性，每一行代表一条记录。
    -NoSQL数据库则没有固定的表格结构，而是以键值对（key-value）的形式存储数据。NoSQL数据库通常使用键来标识数据，而不是使用字段来标识数据。
    存储方式可以是JSON文档、哈希表或者其他方式 。
        选择Sql或NoSql，考虑下面几种因素：
    -ACID vs BASE: SQL数据库支持ACID（原子性、一致性、隔离性、持久性）特性，而NoSQL数据库则支持BASE（基本可用性、软状态、无单点故障）。
    从实用的角度来说，需要考虑面对的应用场景，ACID是否是必须的。
    -扩展性对比：NoSql数据之间无关系，这样就容易扩展，也无形之间，在架构的层面上带来了可扩展等能力。
### 2*、数据库三大范式是什么
    a、第一范式（1NF）：要求数据库表的每一个字段都是原子的，即不能再进行拆分。
    b、第二范式（2NF）：要求在1NF的基础上除了主键外，其他字段还必须依赖主键，而不能依赖非主键字段。
    c、第三范式（3NF）：要求在2NF的基础上除了主键和依赖字段外，其他字段不能再依赖其他字段。
### 3、MySQL怎么连表查询
    数据库有下面集中联表查询方式：
    -内连接（inner join）：内连接返回两个表中有匹配关系的行。
    示例：SELECT employees.name, departments.name 
         FROM employees 
         INNER JOIN departments 
         ON employees.department_id = departments.id;
    这个查询返回每个员工及其所在的部门名称
    -左外连接（left join）：左外连接返回表中的所有行，即使右表中没有匹配的行。未匹配的右表列会包含NULL。
    示例：SELECT employees.name, departments.name
         FROM employees
         LEFT JOIN departments
         ON employees.department_id = departments.id;
    这个查询返回所有员工及其部门名称，包括那些没有分配部门的员工。
    -右外连接（right join）：右外连接返回表中的所有行，即使左表中没有匹配的行。未匹配的左表列会包含NULL。
    -全外连接（full join）：全外连接返回两个表中所有行，包括非匹配行。在MySQL中，FULL join需要使用UNION来实现
    示例：SELECT employees.name, departments.name
         FROM employees
         LEFT JOIN departments
         ON employees.department_id = departments.id
         UNION
         SELECT employees.name, departments.name
         FROM employees
         RIGHT JOIN departments
         ON employees.department_id = departments.id;
    这个查询返回所有员工和所有部门，包括没有匹配行的记录。
### 4、MySQL如何避免重复插入数据
    方式一：使用UNIQUE约束——在字段上添加UNIQUE约束，确保该字段的值在表中是唯一的。 
    示例：CREATE TABLE users (
        id INT AUTO_INCREMENT PRIMARY KEY,
        username VARCHAR(50) UNIQUE,
        password VARCHAR(255) 
        );
    如果上表中尝试重复插入一个username为"john"的记录，MySQL会自动阻止这个操作，并返回错误信息。
    方式二：使用INSERT……ON DUPLICATE KEY UPDATE语句——当插入的数据与表中已有的数据重复时，使用这个语句来更新已有的数据。
    示例：INSERT INTO users (username, password) 
         VALUES ("john", "password")
         ON DUPLICATE KEY UPDATE password = "new_password";
    这个语句会首先尝试插入一个username为"john"的记录，如果该记录已经存在，则更新密码为"new_password"。
    方式三：使用INSERT IGNORE语句——当插入的数据与表中已有的数据重复时，使用这个语句来忽略重复的数据。
    示例：INSERT IGNORE INTO users (username, password)
         VALUES ("john", "password");
    以上三种方式选择的需求：
    - 如果希望确保数据在表中是唯一的，可以使用UNIQUE约束。
    - 如果希望在插入数据时，如果数据重复，则更新已有的数据，可以使用INSERT……ON DUPLICATE KEY UPDATE语句。
    - 如果希望在插入数据时，快速忽略重复插入，可以使用INSERT IGNORE语句。
### 5、外键约束
    外键约束是数据库中一种约束，它用于确保数据在两个表中的关联关系是正确的。外键约束是FOREIGN KEY约束的简称。
    
### 6、MySQL的关键字in和exist
    in和exist是MySQL中的关键字，用于在查询中实现条件判断。
    -in关键字：in关键字用于在查询中判断一个字段的值是否在指定的列表中。
    示例：SELECT * FROM table_name WHERE column_name IN (value1, value2, value3);
    -exist关键字：exist关键字用于在查询中判断一个子查询的结果是否为空。
    示例：SELECT * FROM table_name WHERE EXISTS (SELECT * FROM another_table WHERE condition);
    ·区别与选择：
        性能差异：在大多数情况下，exist的性能优于in，因为exist一旦找到匹配项就会立刻停止查询，而in则会扫描整个子查询结果集
        使用场景：如果子查询结果集较小且不频繁变动，in更合适。而当子查询结果集较大且频繁变动时，exist性能更好。
        NULL值处理：in能够正确处理子查询中包含NULL值的情况，而exist不受NULL值影响。
    

























