import React from "react";
import { Button, Checkbox, Form, Input } from "antd";
import '../css/login.css'
import {Link} from "react-router-dom";
import { createBrowserHistory, createHashHistory } from 'history';
class LoginPage extends React.Component {
  constructor(props) {
    super(props);
  }



  onFinish = (values) => {
    let username=values.username;
    let password=values.password;
    fetch("http://localhost:8080/login/"+username+"/"+password , {
    })
        .then((response) => response.json())
        .then((data) => {
          if(data=="success"){
            const history = createBrowserHistory();
            history.push(
                {
                  pathname:"/MainPage",
                }  );
            history.go();
            return;
          }
          if(data=="failed"){
            alert("用户名或密码错误！")
          }
        })
    console.log('Success:', values);
  };

  onFinishFailed = (errorInfo) => {
    console.log('Failed:', errorInfo);
  };

  render() {
    return (
      <div className='login-container'>
        <div className='login-content'>
          <h1>登录</h1>
          <Form
            name="basic"
            labelCol={{span: 6,}}
            wrapperCol={{span: 16,}}
            onFinish={this.onFinish}
            onFinishFailed={this.onFinishFailed}
            autoComplete="off"
          >

            <Form.Item
              label="用户名"
              name="username"
              rules={[{required: true, message: 'Please input your username!',},]}
            >
              <Input   />
            </Form.Item>

            <Form.Item
              label="密码"
              name="password"
              rules={[{required: true, message: 'Please input your password!',},]}
            >
              <Input.Password    />
            </Form.Item>

            <Form.Item
              name="remember"
              valuePropName="checked"
              wrapperCol={{offset: 8, span: 16,}}
            >
              <Checkbox>Remember me</Checkbox>
            </Form.Item>

            <Form.Item
              wrapperCol={{offset: 8, span: 16,}}
            >
              <Button type="primary" htmlType="submit">
                Log in
              </Button>
            </Form.Item>

            <Form.Item
                wrapperCol={{offset: 8, span: 16,}}
            >
              <Link to={"/RegisterView"}>
                <button type="primary">Register</button>
              </Link>
            </Form.Item>

          </Form>
        </div>
      </div>
    );
  }
}

export default LoginPage;