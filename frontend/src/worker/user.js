import axios from "axios";
import { useAppStore } from "../store/userState";

// export const API_BASE_URL = "https://matching.169.56.100.104.nip.io/match";

export const fetchUser = async (userId) => {
  const response = await axios.get(`/user/${userId}`);
  return response.data;
};

export const loadUser = async (userId) => {
  const store = useAppStore();
  
  const userData = await fetchUser(userId);
  store.user = userData;
  // console.log(store.user)
};

export const fetchMydata = async (userId) => {
  const response = await axios.get(`/user/mydata/${userId}`);
  return response.data;
};

export const loadMydata = async (userId) => {
  const store = useAppStore();
  
  const myDataData = await fetchMydata(userId);
  store.myData = myDataData;
  // console.log(store.myData)
};