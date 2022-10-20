import React, { useEffect, useState } from "react";

import Typography from "@mui/material/Typography";

import DataTable from "../DataTable/DataTable";
import axiosApi from "../../axios/axiosApi";
import { STUDENT } from "../../constant/Api";

const columns = [
  { field: "pkIdStudent", headerName: "ID", width: 70 },
  { field: "firstName", headerName: "First name", width: 130 },
  { field: "lastName", headerName: "Last name", width: 130 },
  {
    field: "fullName",
    headerName: "Full name",
    description: "This column has a value getter and is not sortable.",
    sortable: false,
    width: 160,
    valueGetter: (params) =>
      `${params.row.firstName || ""} ${params.row.lastName || ""}`,
  },
];
const rowsPerPageOptions = [1, 2, 3, 4];

function StudentTable() {

  const [data, setData] = useState(null);
  const [page, setPage] = useState(1);
  const [rowsPerPage, setRowsPerPage] = useState(rowsPerPageOptions[0]);

  useEffect(() => {
    getAllStudent(page, rowsPerPage);
  }, []);

  const getAllStudent = async (page, rowsPerPage) => {
    // console.log(page)
    // console.log(rowsPerPage)
    await axiosApi.post(STUDENT.GET_ALL_STUDENT, {
      // backend min page is 0 so we need decrease 1
      page: page - 1,
      size: rowsPerPage,
      sort: {
        direction: "ASC",
        properties: ["lastName"],
      },
    }).then(response => {
      setData(response.data);
    })
  }

  const onRowsPerPageChange = (event)  => {
    setRowsPerPage(parseInt(event.target.value, 10));
    console.log(event.target.value)
    console.log(rowsPerPage)
    setPage(1);
    getAllStudent(page, rowsPerPage);
  }

  const onPageChange = (event, newPage) => {

  }

  if (data != null) {
    return (
      <div className="App">
        <Typography align="center" variant="h3">
          List Of Students
        </Typography>
        <DataTable
          columns={columns}
          data={data}
          rowsPerPage={rowsPerPage}
          rowsPerPageOptions={rowsPerPageOptions}
          onPageChange={onPageChange}
          onRowsPerPageChange={onRowsPerPageChange}
        />
      </div>
    );
  } else {
    return <div>loading....!</div>
  }

}

export default StudentTable;
