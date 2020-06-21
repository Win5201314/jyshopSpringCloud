package com.zsl.address.controller;

import com.zsl.address.exception.VerifyTokenException;
import com.zsl.address.service.IAddressService;
import com.zsl.address.service.IUserService;
import entity.Address;
import entity.ServerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utils.JWTUtil;

import java.util.List;
import java.util.Map;

/**
 * @author zhangshengli
 */
@Api(value = "快递地址模块")
@RestController
@RequestMapping("/address")
@CrossOrigin
public class AddressController {

    @Autowired
    private IAddressService addressService;
    @Autowired
    private IUserService userService;

    @ApiOperation(value = "添加新地址")
    @PostMapping("/addNewAddress")
    public ServerResponse<String> addNewAddress(@ApiParam(name = "address", value = "地址对象", required = true) Address address,
                                                @ApiParam(name = "token", value = "口令", required = true) String token) throws VerifyTokenException {
        Map<String, Object> map = JWTUtil.verifyToken(token);
        if (map == null) throw new VerifyTokenException("令牌验证失败");
        Long userId = (Long) map.get("userId");
        String openid = (String) map.get("openid");
        if (userService.isExistOpenidAndUserId(openid, userId)) {
            address.setUserId(userId);
            if (addressService.addNewAddress(address)) {
                return ServerResponse.createBySuccess("添加成功");
            } else {
                return ServerResponse.createByErrorMessage("添加失败，请重试");
            }
        } else {
            throw new VerifyTokenException("令牌验证失败");
        }
    }

    @ApiOperation(value = "查询地址")
    @PostMapping("/selectAddress")
    public ServerResponse<List<Address>> selectAddress(@ApiParam(name = "token", value = "口令", required = true) String token) throws VerifyTokenException {
        Map<String, Object> map = JWTUtil.verifyToken(token);
        if (map == null) throw new VerifyTokenException("令牌验证失败");
        Long userId = (Long) map.get("userId");
        String openid = (String) map.get("openid");
        if (userService.isExistOpenidAndUserId(openid, userId)) {
            return ServerResponse.createBySuccess("查询地址成功",
                    addressService.selectAddressByUserId(userId));
        } else {
            throw new VerifyTokenException("令牌验证失败");
        }
    }

    @ApiOperation(value = "删除地址")
    //@VerifyToken
    @PostMapping("/deleteAddress")
    public ServerResponse<String> deleteAddress(@ApiParam(name = "token", value = "口令", required = true) String token,
                                                @ApiParam(name = "addressId", value = "邮件地址主键", required = true) Long addressId) {
        if (addressService.deleteAddress(addressId)) {
            return ServerResponse.createBySuccess("删除成功");
        } else {
            return ServerResponse.createByErrorMessage("删除失败");
        }
    }

    @ApiOperation(value = "更新地址")
    //@VerifyToken
    @PostMapping("/updateAddress")
    public ServerResponse<String> updateAddress(@ApiParam(name = "token", value = "口令", required = true) String token,
                                                @ApiParam(name = "address", value = "地址对象", required = true) Address address) {
        if (addressService.updateAddress(address)) {
            return ServerResponse.createBySuccess("更新成功");
        } else {
            return ServerResponse.createByErrorMessage("更新失败");
        }
    }

}
