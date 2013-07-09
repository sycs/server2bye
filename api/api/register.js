resources.push({
    id:   1001,
    name: "register",
    operations: [
        {
            notes: "验证手机号码",
            path: "/register/verify_mobile",
            http_method: "post",
            format: "json",
            description: "验证手机号码",
            parameters: [
                {
                    parameter: "mobile",
                    value: '13804128888',
                    value_type: 'text',
                    mandatory:'yes',
                    description: "手机号码",
                    data_type: "string"
                }
            ],
            response: {
                data: '{ret:1,errcode:10001}',
                description: 'errcode : 返回错误码,</br>ret : 返回值，0 手机号码可以注册，1 手机号码无法注册'
            },
            return_code: [
                 {
                     errcode: 10001,
                     msg: "手机号码已经被注册",
                 },
                 {
                     errcode: 10002,
                     msg: "手机号码已被禁用",
                 }
            ]
        },//register
        {
            notes: "校对手机验证码",
            path: "/register/verify_mobile_code",
            http_method: "post",
            format: "json",
            description: "验证手机号码",
            parameters: [
                {
                    parameter: "code",
                    value: '565412',
                    value_type: 'text',
                    mandatory:'yes',
                    description: "验证码",
                    data_type: "string"
                }
            ],
            response: {
                data: '{ret:1,errcode:10001}',
                description: 'errcode : 返回错误码,</br>ret : 返回值，0 验证码正确，1 验证码错误'
            },
            return_code: [
                 
            ]
        },//register
        {
            notes: "用户注册",
            path: "/register/add_user",
            http_method: "post",
            format: "json",
            description: "提交用户注册信息",
            parameters: [
                {
                    parameter: "mobile",
                    value: '13804128888',
                    value_type: 'text',
                    mandatory:'yes',
                    description: "手机号码",
                    data_type: "string"
                },
                {
                    parameter: "password",
                    value: 'peter222',
                    value_type: 'text',
                    mandatory:'yes',
                    description: "密码",
                    data_type: "string"
                },
                {
                    parameter: "birthday",
                    value: '1984/08/08',
                    value_type: 'text',
                    mandatory:'yes',
                    description: "生日",
                    data_type: "string"
                },
                {
                    parameter: "usertype",
                    value: 'business',
                    value_type: 'text',
                    mandatory:'yes',
                    description: "用户类型[企业/个人]",
                    data_type: "string"
                },
                {
                    parameter: "image",
                    value: '',
                    value_type: 'file',
                    mandatory:'yes',
                    description: "用户头像,支持JPEG、GIF、PNG格式",
                    data_type: "binary"
                },
            ],
            response: {
                data: '{ret:1,errcode:10001}',
                description: 'errcode : 返回错误码,</br>ret : 返回值，0-成功，1-失败'
            },
            return_code: [
                 {
                     errcode: 10001,
                     msg: "系统错误",
                 },
                 {
                     errcode: 10002,
                     msg: "系统禁止注册",
                 }

            ]
        }//register
        
    ]
});