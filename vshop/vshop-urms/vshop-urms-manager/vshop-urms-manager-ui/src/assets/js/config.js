function Config () {
}
Config.prototype = {
  cookieTimeOut: 120000,
  tokenKey: 'fkvueui_token',
  baseHost: 'http://127.0.0.1:8080',
  isDebug: true,
  login_url: '/sso/login',
  get_plugin: '/file/plugins',
  getMenus: '/api/v1/menus',
  runingApp: '/api/v1/admin/runing',
  appStart: '/api/v1/admin/app/start',
  appStop: '/api/v1/admin/app/stop',
  appRestart: '/api/v1/admin/app/restart',
  webSocket: 'ws://127.0.0.1:8084/api/v1/admin/ws',
  upms_dic: '/api/v1/dictionary',
  upms_office: '/api/v1/office',
  getImages: '/api/v1/admin/app'
}
var config = new Config()
export default config
