import React from "react";
import TablePagination from "@mui/material/TablePagination";

function TablePaginationCustom(props) {
  return (
    <TablePagination
      {...props}
      rowsPerPageOptions={props.rowsPerPageOptions}
      rowsPerPage={props.rowsPerPage}
      component="div"
      count={props.count}
      page={props.page}
      // onPageChange={handleChangePage}
      // onRowsPerPageChange={handleChangeRowsPerPage}
    />
  );
}

export default TablePaginationCustom;
