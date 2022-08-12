import axios from "axios";
import { useAppStore } from "../store/userState";

export const fetchUser = async (userId) => {
  const response = await axios.get(`/user/${userId}`);
  return response.data;
};

export const fetchMyData = async (userId) => {
  const response = await axios.get(`/user/mydata/${userId}`);
  return response.data;
};

export const loadUser = async (userId) => {
  const store = useAppStore();
  store.user = await fetchUser(userId);
};

export const loadMydata = async (userId) => {
  const store = useAppStore();
  // const myDataData = await fetchMydata(userId);
  store.myData = await fetchMydata(userId);
};
