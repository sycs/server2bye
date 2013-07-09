resources.push({
    id:   1002,
    name: "user",
    operations: [
        {
            notes: "用户登录",
            path: "/user/login",
            http_method: "post",
            format: "json",
            description: "用户登录信息接口",
            parameters: [
                {
                    parameter: "mobile",
                    value: "13804128888",
                    value_type: "text",
                    mandatory: 'yes',
                    description: "手机",
                    data_type: "string"
                },
                {
                    parameter: "password",
                    value: "123456",
                    value_type: "text",
                    mandatory: 'yes',
                    description: "密码",
                    data_type: "string"
                }
            ],
            response: {
                data: '{ret:"1","tokenid": "dfc7ad3884e7",errcode:"10001"}',
                description: 'errcode : 返回错误码,</br>ret : 返回值，0-成功，非0-失败'
            },
            return_code: [
                 {
                     errcode: 10001,
                     msg: "用户名不存在",
                 },
                 {
                     errcode: 10002,
                     msg: "密码错误",
                 }
            ]
        },//login
        {
            notes: "用户退出",
            path: "/user/logout",
            http_method: "post",
            format: "json",
            description: "用户退出/注销操作接口",
            parameters: [
                {
                    parameter: "tokenid",
                    value: "dfc7ad3884e7",
                    value_type: "text",
                    mandatory: 'yes',
                    description: "token id",
                    data_type: "string"
                }
            ],
            response: {
                data: '{ret:"1"}',
                description: 'ret : 返回值，0退出失败,1退出成功'
            },
            return_code: [
          
            ]
        },//logout
        {
            notes: "获取用户信息（未完）",
            path: "/user/info",
            http_method: "post",
            format: "json",
            description: "获取用户信息",
            parameters: [
                {
                    parameter: "username",
                    value: "10010",
                    value_type: "text",
                    mandatory: 'yes',
                    description: "用户ID",
                    data_type: "string"
                },
                {
                    parameter: "tokenid",
                    value: "dfc7ad3884e7",
                    value_type: "text",
                    mandatory: 'yes',
                    description: "token id",
                    data_type: "string"
                }
            ],
            response: {
                data: ' {<br />ret:&quot;1&quot;,<br /> errcode:10001,<br />userid:&quot;525252228&quot;,<br />username:&quot;peter888&quot;,<br />nickname:&quot;Peter馗&quot;,<br />sex:1,<br />mobile:&quot;13842277555&quot;,<br />birthday:&quot;1984/08/08&quot;,<br />usertype:1,<br />head_img_url:&quot;/user/getheadimg?username=peter888&quot;<br />}',
                description: 'ret : 返回值，0退出失败,1退出成功'
            },
            return_code: [
          
            ]
        },//logout
        {
            notes: "上传头像",
            path: "/user/update_head",
            http_method: "post",
            format: "json",
            description: "上传用户头像接口",
            parameters: [
                {
                    parameter: "pic",
                    value: "",
                    value_type: "file",
                    mandatory: 'yes',
                    description: "要上传的图片，仅支持JPEG、GIF、PNG格式，图片大小小于5M",
                    data_type: "binary"
                },
                {
                    parameter: "tokenid",
                    value: "dfc7ad3884e7",
                    value_type: "text",
                    mandatory: 'yes',
                    description: "登录时服务端返回的tokenid",
                    data_type: "string"
                }
            ],
            response: {
                data: '{ ret:0 }',
                description: 'ret : 返回值，0 上传成功，1 上传失败'
            },
            return_code: [
                 {
                     errcode: 10001,
                     msg: "上传成功",
                 },
                 {
                     errcode: 10002,
                     msg: "上传失败",
                 }
            ]
        }//upload_image
    ]
});