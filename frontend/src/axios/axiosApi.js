import React from 'react';
import axios from 'axios';
import { BASE_URL } from '../constant/Api';

export default axios.create ({
    baseURL: BASE_URL,
    timeout: 1000
});