import * as React from "react";

import { DataGrid } from "@mui/x-data-grid";
import TablePaginationCustom from "../TablePaginationCustom/TablePaginationCustom";

function DataTable({
  columns,
  rows,
  rowsPerPageOptions,
  rowsPerPage,
  count,
  page,
  actions,
}) {
  return (
    <div style={{ height: 400, width: "100%" }}>
      <DataGrid
        loading={rows != null ? false : true}
        rows={rows != null ? rows : 0}
        columns={columns}
        checkboxSelection
        components={{
          Pagination: (props) => (
            <TablePaginationCustom
              {...props}
              rowsPerPageOptions={rowsPerPageOptions}
              rowsPerPage={rowsPerPage}
              component="div"
              count={count}
              page={page}
              // onPageChange={handleChangePage}
              // onRowsPerPageChange={handleChangeRowsPerPage}
            />
          ),
        }}
      />
    </div>
  );
}

export default DataTable;
