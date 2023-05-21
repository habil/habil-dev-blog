resource "aws_vpc" "vpc" {
  cidr_block                       = "10.20.0.0/16"
  enable_dns_hostnames             = true
  enable_dns_support               = true
  assign_generated_ipv6_cidr_block = true

  tags = {
    Name        = "habil-dev-vpc"
    Environment = "dev"
  }
}