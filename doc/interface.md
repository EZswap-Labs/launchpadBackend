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

#### 3. 查看白单
launchpadWhite/queryUserInWhite
请求参数:

| 字段名称        | 类型   | 说明                                 |
| --------------- | ------ | ------------------------------------ |
|launchpadId | String | launchpadId |
|walletAddress | String | 钱包地址 |
|launchpadStep | int | launchpad阶段.1:空投;2:私募;3:公募 |

#### 3. 查询launchpad详情
launchpad/queryDetail
请求参数:

| 字段名称        | 类型   | 说明                                 |
| --------------- | ------ | ------------------------------------ |
|id | String | launchpadId |
