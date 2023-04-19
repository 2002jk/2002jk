import React from "react";
import '../css/web_top.css'
import {Link} from 'react-router-dom';

class MyHeader extends React.Component {
  constructor(props) {
    super(props);

  }

  handleLogout = e => {

  }

  render() {

    const log = (<Link to='/login'>登录</Link>);

    return (
      <div className="MyHeader">
        <div className="header-container">
          <div className="LeftHeader">
            <ul>
              <li> {log} </li>
            </ul>
          </div>
          <div className="clearfix"> </div>
        </div>
      </div>
    );
  }
}


export default MyHeader;