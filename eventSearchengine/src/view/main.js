import React from "react";
import SearchBar from "../component/search_bar";
import SearchResults from "../component/results";
import MyHeader from "../component/web_top";

class MainPage extends React.Component {

  render() {
    return (
      <div>
        <MyHeader />
        <div className="container">

          <SearchResults />
        </div>
      </div>
    );
  }


}

export default MainPage;