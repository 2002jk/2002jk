import renderer from 'react-test-renderer';
import SearchBar from "../component/search_bar";

it('Renders search result correctly', () => {
  const tree = renderer
    .create(<SearchBar />)
    .toJSON();
  expect(tree).toMatchSnapshot();
});