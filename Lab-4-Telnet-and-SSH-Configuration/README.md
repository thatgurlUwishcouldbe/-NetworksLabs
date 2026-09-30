# Lab 4 – Telnet and SSH Configuration

## Description

This lab demonstrates how to configure and test **Telnet** and **SSH** remote access on a Cisco router using Cisco Packet Tracer.

The network consists of:

* PC1
* Switch
* Router R1

## Task 1 – Telnet

### IP Configuration

**PC1**

* IP Address: `192.168.0.15`
* Subnet Mask: `255.255.255.0`
* Default Gateway: `192.168.0.245`

**R1 Fa0/0**

* IP Address: `192.168.0.245`
* Subnet Mask: `255.255.255.0`

### Telnet Configuration

Telnet was configured on R1 using the VTY line with the password:

`cisco`

An enable secret was also configured:

`ct1306`

The Telnet connection was tested successfully from PC1.

## Task 2 – SSH

### IP Configuration

**PC1**

* IP Address: `10.0.0.2`
* Subnet Mask: `255.0.0.0`
* Default Gateway: `10.0.0.1`

**R1 Fa0/0**

* IP Address: `10.0.0.1`
* Subnet Mask: `255.0.0.0`

### SSH Configuration

SSH was configured on R1 with the following settings:

* Username: `ct1306`
* SSH timeout: `30` seconds
* Authentication retries: `5`
* VTY password: `855`
* RSA key modulus: `800` bits
* Domain name: `example.com`

SSH access was tested successfully from PC1 using:

```bash
ssh -l ct1306 10.0.0.1
```

An enable secret was then configured as:

`ex4`

The final SSH test successfully provided full access to the router.

## Verification

Connectivity was verified using:

```bash
ping 10.0.0.1
```

The ping was successful with:

* Sent: 4
* Received: 4
* Lost: 0%

Both Telnet and SSH remote access were successfully configured and tested.

## Tools Used

* Cisco Packet Tracer
* Cisco Router
* Cisco Switch
* PC1

## File

The Packet Tracer file included with this repository is:

`lab4.pkt`
