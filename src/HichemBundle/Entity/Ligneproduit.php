<?php

namespace HichemBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Ligneproduit
 *
 * @ORM\Table(name="ligneproduit", indexes={@ORM\Index(name="idpanier", columns={"idpanier"}), @ORM\Index(name="idproduit", columns={"idproduit"})})
 * @ORM\Entity(repositoryClass="HichemBundle\Repository\LigneproduitRepository")
 */
class Ligneproduit
{
    /**
     * @var integer
     *
     * @ORM\Column(name="idligne", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idligne;

    /**
     * @var integer
     *
     * @ORM\Column(name="quantite", type="integer", nullable=false)
     */
    private $quantite;

 /*   /**
     * @var \Panier
     *
     * @ORM\ManyToOne(targetEntity="Panier")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="idpanier", referencedColumnName="idpanier")
     * })
     */
    /**
     * @var int
     *
     * @ORM\Column(name="idpanier", type="integer", nullable=false)
     */


    private $idpanier;

    /**
     * @return int
     */
    public function getQuantite()
    {
        return $this->quantite;
    }

    /**
     * @param int $quantite
     */
    public function setQuantite($quantite)
    {
        $this->quantite = $quantite;
    }

   /* /**
     * @return \Panier
     */

    /**
     * @return int
     */
    public function getIdpanier()
    {
        return $this->idpanier;
    }

    /* /**
     * @param \Panier $idpanier
     */

    /**
     * @return int
     */

    public function setIdpanier($idpanier)
    {
        $this->idpanier = $idpanier;
    }

    /**
     * @return \Produit
     */
    public function getIdproduit()
    {
        return $this->idproduit;
    }

    /**
     * @param \Produit $idproduit
     */
    public function setIdproduit($idproduit)
    {
        $this->idproduit = $idproduit;
    }

    /**
     * @var \Produit
     *
     * @ORM\ManyToOne(targetEntity="Produit")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="idproduit", referencedColumnName="idproduit")
     * })
     */
    private $idproduit;

    /**
     * @return int
     */
    public function getIdligne()
    {
        return $this->idligne;
    }

    /**
     * @param int $idligne
     */
    public function setIdligne($idligne)
    {
        $this->idligne = $idligne;
    }


}

