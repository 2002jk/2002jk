import renderer from 'react-test-renderer';
import SearchResults from "../component/results";

it('Renders search result correctly', () => {
  const tree = renderer
    .create(<SearchResults />)
    .toJSON();
  expect(tree).toMatchSnapshot();
});