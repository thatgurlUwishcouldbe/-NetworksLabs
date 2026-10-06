# DHCP Router Configuration Lab

## Overview

This lab demonstrates how to configure a Cisco router as a DHCP server using Cisco Packet Tracer. The lab includes router interface configuration, DHCP configuration, IP address assignment to PCs, network connectivity testing, router configuration verification, and resetting the router configuration.

## Tasks

### Task 1: Configure DHCP Router

The router was configured with the following settings:

- **Router Name:** `RouterA`
- **Interface IP Address:** `192.168.10.1`
- **Subnet Mask:** `255.255.255.0`
- **DHCP Pool Name:** `IPD`
- **Network:** `192.168.10.0/24`
- **Default Gateway:** `192.168.10.1`

### DHCP Configuration

The following addresses were excluded from the DHCP pool:

- `192.168.10.1 – 192.168.10.10`
- `192.168.10.12 – 192.168.10.14`

Therefore, the PCs received the following IP addresses:

| Device | IP Address |
|---|---|
| PC0 | `192.168.10.11` |
| PC1 | `192.168.10.15` |
| PC2 | `192.168.10.16` |

### Connectivity Test

Connectivity between PC0 and PC1 was tested using:

```bash
ping 192.168.10.15
```

The TTL value returned was:

```text
TTL = 128
```

## Task 2: Show Router Configuration

The following Cisco IOS commands were used to verify the router configuration:

```bash
show ip route
```

Displays the current routing table.

```bash
show ip interface brief
```

Displays a brief summary of the router interfaces, including their IP addresses and status.

```bash
show running-config
```

Displays the current running configuration, including the router hostname, interface configuration, and DHCP settings.

## Task 3: Reset Router Configuration

The router's saved startup configuration was erased using:

```bash
erase startup-config
```

The startup configuration was then verified using:

```bash
show startup-config
```

The current running configuration was also displayed using:

```bash
show running-config
```

## Tools Used

- Cisco Packet Tracer
- Cisco IOS CLI
- DHCP
- IPv4
- Ping

## Conclusion

This lab provided practical experience in configuring a Cisco router as a DHCP server, assigning IP addresses automatically to PCs, testing network connectivity, viewing router configurations, and resetting the router's saved configuration.
