import React, { useEffect, useState } from "react";

import { DataGrid } from "@mui/x-data-grid";
import TablePaginationCustom from "../TablePaginationCustom/TablePaginationCustom";

function DataTable({
  columns,
  data,
  rowsPerPage,
  rowsPerPageOptions,
  onPageChange,
  onRowsPerPageChange
}) {

  const [rows, setRows] = useState(data.content);
  const [totalPages, setTotalPages] = useState(data.totalPages);
  const [pageNumber, setPageNumber] = useState(data.pageable.pageNumber)
  const [pageSize, setPageSize] = useState(data.pageable.pageSize)

  return (
    <div style={{ height: 400, width: "100%" }}>
      <DataGrid
        loading={data != null ? false : true}
        rows={rows != null ? rows : null}
        columns={columns}
        checkboxSelection
        getRowId={(row) => row.pkIdStudent}
        components={{
          Pagination: (props) => (
            <TablePaginationCustom
              totalPages={totalPages}
              pageNumber={pageNumber}
              rowsPerPage={rowsPerPage}
              rowsPerPageOptions={rowsPerPageOptions}
              onPageChange={onPageChange}
              onRowsPerPageChange={onRowsPerPageChange}
            />
          ),
        }}
      />
    </div>
  );
}

export default DataTable;
