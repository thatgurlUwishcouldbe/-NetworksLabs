# Lab 2 - LAN Network Configuration

## Objective

Build and configure a simple LAN using one router, one switch, and two PCs with static IPv4 addressing.

## Topology

- 1 Router
- 1 Switch
- 2 PCs

## IP Addressing

| Device | IP Address | Subnet Mask |
| --- | --- | --- |
| PC0 | 192.168.1.2 | 255.255.255.0 |
| PC1 | 192.168.1.3 | 255.255.255.0 |
| Router Interface | 192.168.1.1 | 255.255.255.0 |

## Tasks Completed

- Configured static IP addresses on the PCs.
- Configured the router interface.
- Set router hostname and passwords.
- Configured local user authentication and Telnet access.
- Verified the configuration with `ipconfig` and `ping`.

## Learning Note: Default Gateway

I accidentally entered `129.168.1.1` as the default gateway instead of `192.168.1.1`.

The devices could still communicate because PC0, PC1, and the router interface were all in the same subnet: `192.168.1.0/24`. Communication within the same subnet is sent directly to the destination and does not use the default gateway.

The default gateway is needed when a device communicates with a different network. I corrected the default gateway to `192.168.1.1`.

## Files

- `lab2.pkt`: Cisco Packet Tracer lab file.

> This lab was completed for academic learning purposes.
