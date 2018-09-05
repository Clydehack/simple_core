/*
此文件为全局的配置文件
*/
// 192.168.2.183
// 47.94.131.226
const config_service_url = '/zeroCore/'; // 展示服务地址
const config_img_url = 'http://localhost:8002/zeroBack/'; // 提供图片的地址
const systemName = '3D图片旋转'; // 系统名称
const nativeData = true; // 是否启用本地数据, 获取本地数据用GET方法
const page_size_common = 8;
const page_size_360 = 3;
const loadingStyle = { // 数据预加载时显示的样式
  text: '数据统计中，请稍等',
  color: '#c23531',
  textColor: '#FF9606',
  maskColor: 'rgba(255, 255, 255, 0.2)',
  zlevel: 0
}
