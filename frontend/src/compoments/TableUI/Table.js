// import React from "react";

// import Paper from "@mui/material/Paper";
// import TableHead from "@mui/material/TableHead";
// import TablePaginationActions from "./TablePaginationActions";
// import TableCell from "@mui/material/TableCell";
// import TableFooter from "@mui/material/TableFooter";
// import TablePagination from "@mui/material/TablePagination";
// import TableRow from "@mui/material/TableRow";
// import TableContainer from "@mui/material/TableContainer";

// function renderHeaderTable(header) {
//   if (header == null) {
//     return null;
//   }
//   return (
//     <TableHead>
//       {header.map((column) => {
//         <TableCell>{column}</TableCell>;
//       })}
//     </TableHead>
//   );
// }

// function Table({ header, tableBody, RequestPagination }) {
//   const listSize = [1, 2, 3];
//   const [page, setPage] = React.useState(0);
//   const [size, setSize] = React.useState(listSize[0]);
//   const [totalPage, setTotalPage] = React.useState(0);

//   const handleChangePage = (event, newPage) => {
//     if (newPage < totalPage) {
//       setPage(newPage);
//     }
//   };

//   const handleChangeRowsPerPage = (event) => {
//     setSize(event.target.value);
//   };

//   return (
//     <TableContainer component={Paper}>
//       <Table sx={{ minWidth: 500 }} aria-label="custom pagination table">
//         {/* {renderHeaderTable(header)} */}
//         {tableBody}
//         <TableFooter>
//           <TableRow>
//             <TablePagination
//               rowsPerPageOptions={listSize}
//               colSpan={3}
//               count={
//                 RequestPagination == null ? 0 : RequestPagination.totalPages
//               }
//               rowsPerPage={size}
//               page={page}
//               SelectProps={{
//                 inputProps: {
//                   "aria-label": "rows per page",
//                 },
//                 native: true,
//               }}
//               onPageChange={handleChangePage}
//               onRowsPerPageChange={handleChangeRowsPerPage}
//               ActionsComponent={TablePaginationActions}
//               labelDisplayedRows={function () {
//                 return `1–${size} of ${
//                   totalPage !== -1 ? totalPage : `more than ${size}`
//                 }`;
//               }}
//             />
//           </TableRow>
//         </TableFooter>
//       </Table>
//     </TableContainer>
//   );
// }
// export default Table;
