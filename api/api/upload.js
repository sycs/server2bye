resources.push({
    id:   1004,
    name: "form/upload",
    operations: [
        {
            notes: "上传媒体文件",
            path: "/form/upload",
            http_method: "post",
            format: "json",
            description: "上传图片、语音、视频等<br>文件图片（image）: 1MB，支持JPG格式",
            parameters: [
                {
                    parameter: "type",
                    value: "image",
                    value_type: "file",
                    mandatory: 'yes',
                    description: "媒体文件类型，包括图片（image）、视频（video）和缩略图（thumb）",
                    data_type: "string"
                },
                {
                    parameter: "media",
                    value: "30.525565",
                    value_type: "text",
                    mandatory: 'yes',
                    description: "form-data中媒体文件标识，有filename、filelength、content-type等信息",
                    data_type: "binary"
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