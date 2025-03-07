# Study_java_redis
    redis提供了丰富的数据类型，常用物种类型：String、Hash、List、Set、ZSet
## 数据结构
### Zset使用示例
    用zset实现排行榜的功能：
    # arcticle:1文章获得了200点赞
    ZADD user:guangyin:ranking 200 arcticle:1
    # arcticle:2文章获得了40点赞
    ZADD user:guangyin:ranking 40 arcticle:2
    # arcticle:3文章获得了100点赞
    ZADD user:guangyin:ranking 100 arcticle:3
    # article:4文章获得了20点赞
    ZADD user:guangyin:ranking 20 arcticle:4
    # article:5文章获得了50点赞
    ZADD user:guangyin:ranking 50 arcticle:5
    -文章arcticle：4新增点赞数20，更新后的点赞数是30可以使用ZINCRBY命令（为有序集合key中元素member的分值加上increment）
    ZINCRBY user:guangyin:ranking 20 arcticle:4
    -查看某篇文章的赞数，可以使用ZSCORE命令（返回有序集合key中元素个数）
    ZSCORE user:guangyin:ranking arcticle:4
    -获取文章赞数最多的三篇文章，可以使用ZREVRANGE命令（返回有序集合key中分值在max和min之间（包括等于max和min）的元素，且按分值从大到小排序）
    ZREVRANGE user:guangyin:ranking 0 2 WITHSCORES  
### Zset低层是如何实现的
    是有压缩列表或跳表实现的
### 跳表如何实现
    调表是在链表基础上实现的，实现了一种[多层]的有序链表



























