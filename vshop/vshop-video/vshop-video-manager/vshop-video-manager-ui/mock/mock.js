/**
 * mock
 */
const dictionary=require('./data/dictionary.json')
const menu=require('./data/menus.json')
const office=require('./data/office.json')
const express=require('express')
const app=express()
var apiRouters=express.Router()
app.use('/api/v1',apiRouters)
module.exports = {
    mock:{
        init: function(app){
            app.get('/api/v1/dictionary',(req,res)=>{
                res.json({
                  code:200,
                  body:dictionary
                })
            })
            app.get('/api/v1/menus',(req,res)=>{
                res.json({
                  code:200,
                  body:menu
                })
            })
            app.get('/api/v1/office',(req,res)=>{
                res.json({
                  code:200,
                  body:office
                })
            })
        }
    }
}