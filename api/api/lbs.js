resources.push({
    id: 1003,
    name: "lbs",
    operations: [
        {
            notes: "更新地理位置",
            path: "/lbs/update_pos",
            http_method: "post",
            format: "json",
            description: "此接口主要用于更新当前用户地理位置信息",
            parameters: [
                {
                    parameter: "uid",
                    value: "562354",
                    value_type: "text",
                    mandatory: 'yes',
                    description: "用户唯一ID",
                    data_type: "string"
                },
                {
                    parameter: "longitude",
                    value: "30.525565",
                    value_type: "text",
                    mandatory: 'yes',
                    description: "经度，例如：30.525565",
                    data_type: "string"
                },
                {
                    parameter: "latitude",
                    value: "15.956855",
                    value_type: "text",
                    mandatory: 'yes',
                    description: "纬度，例如：15.956855",
                    data_type: "string"
                }
            ],
            response: {
                data: '{ret:"1",errcode:"1"}',
                description: 'errcode : 返回错误码,</br>ret : 返回值，0-成功，非0-失败'
            },
            return_code: [
                 {
                     errcode: 1,
                     msg: "调用接口出错",
                 }
            ]
        },
        {
            notes: "删除地理位置",
            path: "/lbs/delete_pos",
            http_method: "post",
            format: "json",
            description: "本接口用于删除当前帐号最后一次的更新的地理位置。",
            parameters: [
                {
                    parameter: "uid",
                    value: "562354",
                    value_type: "text",
                    mandatory: 'yes',
                    description: "用户唯一ID",
                    data_type: "string"
                }
            ],
            response: {
                data: '{ret:"1",errcode:"1"}',
                description: 'errcode : 返回错误码,</br>ret : 返回值，0-成功，非0-失败'
            },
            return_code: [
                 {
                     errcode: 1,
                     msg: "调用接口出错",
                 }
            ]
        }
    ]
});