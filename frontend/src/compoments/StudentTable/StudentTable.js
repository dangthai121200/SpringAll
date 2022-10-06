import React, { useEffect } from "react";

import Typography from "@mui/material/Typography";

import DataTable from "../DataTable/DataTable";
import axiosApi from "../../axios/axiosApi";
import { STUDENT } from "../../constant/Api";

const columns = [
  { field: "id", headerName: "ID", width: 70 },
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

const rows = null;
const rowsPerPageOptions = [5, 10, 15];
const rowsPerPage = 5;

function StudentTable() {
  useEffect(() => {
    axiosApi.post(STUDENT.GET_ALL_STUDENT, {
      page: "1",
      size: "3",
      sort: {
        direction: "ASC",
        properties: ["lastName"],
      },
    });
  }, []);

  return (
    <div className="App">
      <Typography align="center" variant="h3">
        List Of Students
      </Typography>
      <DataTable
        columns={columns}
        rows={rows}
        rowsPerPageOptions={rowsPerPageOptions}
        rowsPerPage={rowsPerPage}
      />
    </div>
  );
}

export default StudentTable;
