# Lab 3 - Socket Programming

## Objective

Practice client-server communication using Java sockets and understand the difference between TCP and UDP transport protocols.

## Tasks Completed

### Task 1 - TCP and UDP Socket Examples

Implemented the TCP and UDP socket programming examples from the Chapter 2 slides.

- TCP uses a connection-oriented communication model.
- UDP uses a connectionless communication model.
- Created client and server programs for both protocols.

### Task 2 - Simple DNS-Like Application Using TCP

Implemented a simple DNS-like client-server application using the TCP protocol.

The client sends a website name as text to the server. The server searches for the associated IP address and sends the result back to the client.

## Port Configuration

| Application Component | Port Number |
| --- | --- |
| DNS-like Server | `3456` |
| DNS-like Client | `9876` |

## Example DNS Records

| Website Name | IP Address |
| --- | --- |
| `www.stc.com.sa` | `212.118.156.22` |
| `www.ksu.edu.sa` | `52.174.29.241` |

> The records above are the sample values provided in the lab sheet for this simulation.

## Concepts Practiced

- Java socket programming
- Client-server architecture
- TCP communication
- UDP communication
- Port numbers
- Application-layer protocols
- Sending and receiving text through sockets
- Simple DNS name-to-IP address resolution

## Files

- `TCPServer.java` - TCP server implementation.
- `TCPClient.java` - TCP client implementation.
- `UDPServer.java` - UDP server implementation.
- `UDPClient.java` - UDP client implementation.
- `SimpleDnsServer.java` - DNS-like TCP server running on port `3456`.
- `SimpleDnsClient.java` - DNS-like TCP client using port `9876`.

> This lab was completed for academic learning purposes as part of IT1340 - Computer Networks.
