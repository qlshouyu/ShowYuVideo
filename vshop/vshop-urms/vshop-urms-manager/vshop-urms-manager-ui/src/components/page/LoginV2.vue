<template>
  <div class="box-bg">
    <el-card class="box-card">
      <el-form :model="loginUser" :rules="rules" ref="ruleForm" label-width="0px" class="longin-form">
        <div class="form-group">
          <h3>您好！欢迎登录</h3>
        </div>
        <div class="form-group">
          <el-input class="login-input" placeholder="请输入账户" prefix-icon="el-icon-tickets" v-model="loginUser.loginName"> </el-input>
        </div>
        <div class="form-group">
          <el-input class="login-input" placeholder="请输入密码" prefix-icon="el-icon-tickets" v-model="loginUser.pwd"> </el-input>
        </div>
        <el-button class="login-submit" @click="submitForm" type="primary">登录</el-button>
      </el-form>
    </el-card>
    <img class="login-mid-bg" src="../../assets/img/login-img.png"/>
  </div>
</template>

<script>
export default {
  name: 'LoginV2',
  data: function () {
    return {
      loginUser: {
        pwd: '',
        loginName: ''
      },
      rules: {
        userName: [
          {required: true, message: '请输入用户名', trigger: 'blur'}
        ],
        pwd: [
          {required: true, message: '请输入密码', trigger: 'blur'}
        ]
      }
    }
  },
  methods: {
    submitForm () {
      var that = this
      console.warn('登录中')
      // that.$util.cache.putUser(data.body) // 缓存用户
      that.$util.cookie.setCookie(that.$config.tokenKey, 'token', that.$config.cookieTimeOut) // 缓存token
      that.$router.push('/')
      // this.$refs['ruleForm'].validate((valid) => {
      //   if (valid) {
      //     that.$post({
      //       url: that.$config.login_url,
      //       data: that.loginUser,
      //       success: function (data) {
      //         that.$util.log(data)
      //         that.$util.cache.putUser(data.body) // 缓存用户
      //         that.$util.cookie.setCookie(that.$config.tokenKey, data.token, that.$config.cookieTimeOut) // 缓存token
      //         that.$router.push('/')
      //       }
      //     })
      //   } else {
      //     console.log('验证不通过')
      //     return false
      //   }
      // })
    }
  }
}
</script>

<style scoped>
  .box-card {
    width: 300px;
    height: 300px;
    position:absolute;
    right: 10%;
    top: 50%;
    margin-top: -150px;
    padding:20px;
    z-index: 100;
  }
  .login-mid-bg{
    height: 70%;
    position: absolute;
    left: 10%;
    top: 50%;
    margin-top: -15%
  }
  .box-card h3{
    margin-bottom: 20px
  }
  .login-input{
    margin-bottom: 18px
  }
  .login-submit{
    width: 100%;
    height: 40px;
    margin-top: 10px
  }
  .box-bg{
    height: 100%;
    width: 100%;
    background-image: url(../../assets/img/login-bg.png);
    position: relative;
  }
</style>
