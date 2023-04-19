// these imports are something you'd normally configure Jest to import for you
// automatically. Learn more in the setup docs: https://testing-library.com/docs/react-testing-library/setup#cleanup
import '@testing-library/jest-dom'
// NOTE: jest-dom adds handy assertions to Jest and is recommended, but not required

import * as React from 'react'
import {render, fireEvent, screen} from '@testing-library/react'
import SearchResults from "./results";

// test('Text result', () => {
//   render(<TextRes res={{
//     url: 'https://www.baidu.com',
//     name: '事件相关信息',
//     date: '2022-6-23'
//   }} />)
//
//   expect(screen.getByText(/事件相关信息/i)).toBeInTheDocument()
//   expect(screen.getByText(/2022-6-23/i)).toBeInTheDocument()
//
// })

test('Search result change after click', () => {
  render(<SearchResults />)

  fireEvent.click(screen.getByText(/时间线/i))

  expect(screen.getAllByText(/6-23/i)).not.toBeNull()
  expect(screen.queryByText(/人物/i)).toBeNull()

  fireEvent.click(screen.getByText(/思维导图/i))

  expect(screen.getByText(/人物/i)).toBeInTheDocument()
  expect(screen.queryByText(/6-23/i)).toBeNull()


})