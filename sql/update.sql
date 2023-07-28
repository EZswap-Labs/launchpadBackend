ALTER TABLE `ezswap`.`launchpad`
    ADD COLUMN `public_every_user_min_mint_limit` int NULL AFTER `signer`,
ADD COLUMN `airdrop_every_user_min_mint_limit` int NULL AFTER `public_every_user_min_mint_limit`,
ADD COLUMN `white_mint_every_user_min_mint_limit` int NULL AFTER `airdrop_every_user_min_mint_limit`,
ADD COLUMN `private_every_user_min_mint_limit` int NULL AFTER `white_mint_every_user_min_mint_limit`;