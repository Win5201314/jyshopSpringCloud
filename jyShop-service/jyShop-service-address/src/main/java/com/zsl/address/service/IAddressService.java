package com.zsl.address.service;

import entity.Address;

import java.util.List;

public interface IAddressService {

    boolean addNewAddress(Address address);
    List<Address> selectAddressByUserId(long userId);
    boolean deleteAddress(long addressId);
    boolean updateAddress(Address address);
}
