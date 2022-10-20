import React from "react";
import TablePagination from "@mui/material/TablePagination";

function TablePaginationCustom({ totalPages, pageNumber, rowsPerPageOptions, rowsPerPage, onPageChange, onRowsPerPageChange }) {
  return (
    <TablePagination

      component="div"
      count={totalPages}
      page={pageNumber}
      rowsPerPageOptions={rowsPerPageOptions}
      rowsPerPage={rowsPerPage}
      onPageChange={onPageChange}
      onRowsPerPageChange={onRowsPerPageChange}
      labelDisplayedRows={({ from, to, count }) => /* backend min page is 0 so we need increase 1 */ `Page ${pageNumber + 1} of total ${count} pages`}
    />
  );
}

export default TablePaginationCustom;
