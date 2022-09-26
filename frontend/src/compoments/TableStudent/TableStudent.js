import * as React from "react";
import PropTypes from "prop-types";
import { useTheme } from "@mui/material/styles";
import Box from "@mui/material/Box";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell, { tableCellClasses } from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableFooter from "@mui/material/TableFooter";
import TablePagination from "@mui/material/TablePagination";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import IconButton from "@mui/material/IconButton";
import FirstPageIcon from "@mui/icons-material/FirstPage";
import KeyboardArrowLeft from "@mui/icons-material/KeyboardArrowLeft";
import KeyboardArrowRight from "@mui/icons-material/KeyboardArrowRight";
import LastPageIcon from "@mui/icons-material/LastPage";
import TableHead from "@mui/material/TableHead";
import { styled } from "@mui/material/styles";

import axiosApi from "../../axios/axiosApi";

function TablePaginationActions(props) {
  const theme = useTheme();
  const { count, page, rowsPerPage, onPageChange } = props;
 

  const handleFirstPageButtonClick = (event) => {
    onPageChange(event, 0);
  };

  const handleBackButtonClick = (event) => {
    onPageChange(event, page - 1);
  };

  const handleNextButtonClick = (event) => {
    onPageChange(event, page + 1);
  };

  const handleLastPageButtonClick = (event) => {
    onPageChange(event, Math.max(0, Math.ceil(count / rowsPerPage) - 1));
  };

  return (
    <Box sx={{ flexShrink: 0, ml: 2.5 }}>
      <IconButton
        onClick={handleFirstPageButtonClick}
        disabled = {page === 0}
        aria-label="first page"
      >
        {theme.direction === "rtl" ? <LastPageIcon /> : <FirstPageIcon />}
      </IconButton>

      <IconButton
        onClick={handleBackButtonClick}
        disabled={page === 0}
        aria-label="previous page"
      >
        {theme.direction === "rtl" ? (
          <KeyboardArrowRight />
        ) : (
          <KeyboardArrowLeft />
        )}
      </IconButton>

      <IconButton
        onClick={handleNextButtonClick}
        disabled={page === count - 1}
        aria-label="next page"
      >
        {theme.direction === "rtl" ? (
          <KeyboardArrowLeft />
        ) : (
          <KeyboardArrowRight />
        )}
      </IconButton>

      <IconButton
        onClick={handleLastPageButtonClick}
        disabled={page === count - 1}
        aria-label="last page"
      >
        {theme.direction === "rtl" ? <FirstPageIcon /> : <LastPageIcon />}
      </IconButton>
    </Box>
  );
}

TablePaginationActions.propTypes = {
  count: PropTypes.number.isRequired,
  onPageChange: PropTypes.func.isRequired,
  page: PropTypes.number.isRequired,
  rowsPerPage: PropTypes.number.isRequired,
};



function TableStudent() {

  const listSize = [1, 2, 3];

  const [page, setPage] = React.useState(0);
  const [size, setSize] = React.useState(listSize[0]);
  const [totalPage, setTotalPage] = React.useState(0);

  const [studentPagination, setStudentPagination] = React.useState(null);

  React.useEffect(() => {
    getListStudent(page, size);
  }, []);

  // Avoid a layout jump when reaching the last page with empty rows.
  // const emptyRows =
  //   page > 0 ? Math.max(0, (1 + page) * rowsPerPage - rows.length) : 0;

  const handleChangePage = (event, newPage) => {
    if(newPage < totalPage){
      setPage(newPage);
      getListStudent(newPage, size);
    }
  };

  const handleChangeRowsPerPage = (event) => {
      setSize(event.target.value);
      getListStudent(page, event.target.value);
  };

  async function getListStudent(page, size) {
    await axiosApi
      .post("/student", {
        page: page,
        size: size,
        sort: {
          direction: "ASC",
          properties: ["lastName"],
        },
      })
      .then(function (response) {
        setStudentPagination(response.data);
        setTotalPage(response.data.totalPages);
        console.log(response.data);
      });
  }

  return (
    <TableContainer component={Paper}>
      <Table sx={{ minWidth: 500 }} aria-label="custom pagination table">
        <TableHead>
          <TableRow>
            <TableCell align="center">ID</TableCell>
            <TableCell align="center">LAST NAME</TableCell>
            <TableCell align="center">FIRST NAME&nbsp;(g)</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {studentPagination != null
            ? studentPagination.content.map((row) => (
                <TableRow
                  key={row.pkIdStudent}
                >
                  <TableCell align="center" component="th" scope="row">
                    {row.pkIdStudent}
                  </TableCell>
                  <TableCell align="center">{row.firstName}</TableCell>
                  <TableCell align="center">{row.lastName}</TableCell>
                </TableRow>
              ))
            : null}
        </TableBody>
        <TableFooter>
          <TableRow>
            <TablePagination
              rowsPerPageOptions={listSize}
              colSpan={3}
              count={
                studentPagination == null ? 0 : studentPagination.totalPages
              }
              rowsPerPage={size}
              page={page}
              SelectProps={{
                inputProps: {
                  "aria-label": "rows per page",
                },
                native: true,
              }}
              onPageChange={handleChangePage}
              onRowsPerPageChange={handleChangeRowsPerPage}
              ActionsComponent={TablePaginationActions}
              labelDisplayedRows = {function() {return `1–${size} of ${totalPage !== -1 ? totalPage : `more than ${size}`}`; }}
            />
          </TableRow>
        </TableFooter>
      </Table>
    </TableContainer>
  );
}

export default TableStudent;
