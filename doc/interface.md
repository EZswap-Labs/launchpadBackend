base url: https://launchpadtest.ezswap.io/api/

#### 1.banner列表 
artBanner/queryList
请求参数:

| 字段名称        | 类型   | 说明                                 |
| --------------- | ------ | ------------------------------------ |
| network            | String | 测试还是线上，测试库：dev，主网：pro ， matic：matic_main matic_dev|

#### 2. 艺术家列表, 返回当前艺术家mint的项目
userAccount/queryList
请求参数:

| 字段名称        | 类型   | 说明                                 |
| --------------- | ------ | ------------------------------------ |
|contractAddressOrName | String | 合约名字或合约地址/艺术家名字也能查,支持模糊搜索 |
