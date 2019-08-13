// KindEditor.ready(function(K) {
//     ctx = $("#ctx").val();
//     var editor = K.create('#editor', options);
//     editor.html("请输入招考公告内容");
//     //此时才将主div显示，防止editor加载慢造成页面乱跳
//     $(".main").css("opacity","1");
//     hideLoading();
//     //实现招考公告预览(调用父窗体的js方法)
//     $(".preview").click(function(){
//         var html = editor.html();
//         window.parent.previewNews(html);
//     });
//     // 实例化一个plupload上传对象
//     var imgUploader = new plupload.Uploader({
//         browse_button : 'browse', //触发文件选择对话框的按钮，为那个元素id
//         url : ctx+'/addNotice.action', //注意，这个没有接受地址，只作为中间部件使用，当提交的时候将这个对象里的文件整合到videoUploader里
//         flash_swf_url : ctx+'/plugins/plupload-2.3.6/js/Moxie.swf', //swf文件，当需要使用swf方式进行上传时需要配置该参数
//         silverlight_xap_url : ctx+'/plugins/plupload-2.3.6/js/Moxie.xap', //silverlight文件，当需要使用silverlight方式进行上传时需要配置该参数
//         multi_selection:false,//设置不可在选择时选择多个文件
//         filters: {
//             mime_types : [ //只允许上传图片
//                 { title : "Image files", extensions : "jpg,gif,png" },
//             ],
//             max_file_size : '3mb', //最大只能上传3mb的文件
//             prevent_duplicates : true //不允许选取重复文件
//         },
//         file_data_name:"imgFile"
//     });
//     // 在实例对象上调用init()方法进行初始化
//     imgUploader.init();
//     // 绑定各种事件，并在事件监听函数中做你想做的事
//     // 当添加文件时
//     imgUploader.bind('FilesAdded', function(uploader, files) {
//         $("#starimg").text("已选择[" + files[0].name + "]");
//
//     });
//     // 出错时
//     imgUploader.bind('Error', function(uploader, errObject) {
//         if (errObject.code == plupload.FILE_EXTENSION_ERROR) {
//             // 文件类型选择有问题
//             showTips("请选择正确的图片格式");
//             return;
//         }
//         if (errObject.code == plupload.FILE_SIZE_ERROR) {
//             // 文件大小超出
//             showTips("最高上传3Mb文件");
//             return;
//         }
//         showTips("error:" + errObject.code + ":" + errObject.file + ":" + errObject.message );
//     });
//     //招考公告发布提交按钮
//     $(".submitBtn").click(function(){
//         var description = editor.html();
//         if(checkData()){
//             showLoading();
//             $(".spinner").css("visibility","visible");
//             $("#hiddenArea").val(editor.html());
//             hideLoading();
//             $('#form').ajaxSubmit(
//                 {
//                     url : url+"YucaiAdmin/addNotice.action" ,
//                     dataType : 'text',
//                     success : showTips(true)
//                 });
//             $(".spinner").css("visibility","hidden");
//         }else{
//             //使用layui进行弹出框
//             showTipsEmpty();
//         }
//     });
//     //清除按钮
//     $(".clearBtn").click(function(){
//         clearPage();
//     })
//
//     //清除页面内容
//     function clearPage(){
//         $(".noticeTitle").val("");
//         editor.html("请输入招考公告内容");
//         $(".source").val("");
//         $(".author").val("");
//         $(".selectLable").val("0");
//     }
//
//     //进行页面数据的检验
//     function checkData(){
//         if($(".selectLable").val()=="0"){
//             return false;
//         }
//         if($(".noticeTitle").val()==""){
//             return false;
//         }
//         if(editor.html()==""){
//             return false;
//         }
//
//         if($(".source").val()==""){
//             return false;
//         }
//         if($(".author").val()==""){
//             return false;
//         }
//         return true;
//     }
//
//
//     function showTips(flag) {
//         var text;
//         if (flag == true) {
//             text = "发布成功";
//         } else {
//             text = "发布失败";
//         }
//         // 显示弹出框
//         layui.use('layer', function() {
//             var layer = layui.layer;
//             layer.open({
//                 content : '<div style="text-align:center">' + text + '</div>',
//                 btn : [ '确定', '取消' ],
//                 btnAlign : 'c',
//                 closeBtn : 1,
//                 anim : 5,
//                 isOutAnim : true,
//                 move : '.layui-layer-title',
//                 yes : function(index, layero) {
//                     if (flag == true) {
//                         clearPage();
//                     }
//                     layer.close(index);
//                 }
//             });
//         });
//     }
//
// });