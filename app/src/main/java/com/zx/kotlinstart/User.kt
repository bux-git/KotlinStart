package com.zx.kotlinstart

/**
 * description：
 * author：bux on 2019/8/1 18:03
 * email: 471025316@qq.com
 */
class User{
    var userName:String?=null;
    var passWord:String?=null;
    var code:String?=null;

    constructor()

    constructor(userName: String?, passWord: String?, code: String?) {
        this.userName = userName
        this.passWord = passWord
        this.code = code
    }


}